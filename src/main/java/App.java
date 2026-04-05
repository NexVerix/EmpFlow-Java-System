import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public", Location.CLASSPATH);
        }).start(7070);

        // --- AUTHENTICATION ---
        app.post("/signup", ctx -> {
            String data = ctx.formParam("username") + ":" + ctx.formParam("password");
            Files.writeString(Paths.get("users.txt"), data + "\n", StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE);
            ctx.redirect("/");
        });

        app.post("/login", ctx -> {
            String attempt = ctx.formParam("username") + ":" + ctx.formParam("password");
            List<String> users = Files.exists(Paths.get("users.txt")) ? Files.readAllLines(Paths.get("users.txt"))
                    : new ArrayList<>();
            if (users.contains(attempt))
                ctx.redirect("/dashboard.html");
            else
                ctx.html("<h1>Login Failed</h1><a href='/'>Try Again</a>");
        });

        // --- CRUD OPERATIONS ---

        // CREATE
        app.post("/api/add", ctx -> {
            String employeeData = String.join("|",
                    ctx.formParam("id"), ctx.formParam("name"),
                    ctx.formParam("dept"), ctx.formParam("phone"), ctx.formParam("address"));
            Files.writeString(Paths.get("employees.txt"), employeeData + "\n", StandardOpenOption.APPEND,
                    StandardOpenOption.CREATE);
            ctx.redirect("/dashboard.html");
        });

        // READ
        app.get("/api/list", ctx -> {
            if (!Files.exists(Paths.get("employees.txt"))) {
                ctx.result("");
                return;
            }
            ctx.result(Files.readString(Paths.get("employees.txt")));
        });

        // DELETE
        // DELETE ROUTE - Place this inside your main method
        app.post("/api/delete", ctx -> {
            String idToDelete = ctx.formParam("id");

            if (idToDelete == null || idToDelete.isEmpty()) {
                ctx.status(400).result("ID is missing");
                return;
            }

            Path path = Paths.get("employees.txt");
            if (Files.exists(path)) {
                // Read all lines
                List<String> lines = Files.readAllLines(path);

                // Filter out the line that starts with the ID you want to delete
                List<String> updatedLines = lines.stream()
                        .filter(line -> !line.startsWith(idToDelete + "|"))
                        .collect(java.util.stream.Collectors.toList());

                // Overwrite the file with the new list (using TRUNCATE_EXISTING to clear the
                // old data)
                Files.write(path, updatedLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            }

            // Send the user back to the dashboard to see the updated list
            ctx.redirect("/dashboard.html");
        });
    }
}