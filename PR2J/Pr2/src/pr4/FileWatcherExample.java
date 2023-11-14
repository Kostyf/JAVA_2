package pr4;

import difflib.DiffUtils;
import difflib.Patch;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileWatcherExample {
    private static List<String> readFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Path dir = Paths.get("2222");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

        while (true) {
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    System.out.println("File created: " + event.context());
                } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    Path file = dir.resolve((Path) event.context());
                    List<String> oldContent = readFile(file);
                    // Wait for the file to be fully written
                    Thread.sleep(1000);
                    List<String> newContent = readFile(file);
                    Patch<String> patch = DiffUtils.diff(oldContent, newContent);
                    System.out.println("File modified: " + event.context());
                    System.out.println("Added lines: " + patch.getDeltas().stream().flatMap(delta -> delta.getRevised().getLines().stream()).toList());
                    System.out.println("Removed lines: " + patch.getDeltas().stream().flatMap(delta -> delta.getOriginal().getLines().stream()).toList());
                } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                    System.out.println("File deleted: " + event.context());
                }
            }
            key.reset();
        }
    }
}
