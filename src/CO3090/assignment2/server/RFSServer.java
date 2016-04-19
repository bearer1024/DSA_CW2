package CO3090.assignment2.server;

import CO3090.assignment2.*;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

//Question (2.3)
public class RFSServer extends UnicastRemoteObject implements RFSInterface {
    final static String fileSystemPath="./filesystems/";

    Vector<String> fsIndex;

    public RFSServer() throws RemoteException {
       super();

       fsIndex = FileUtility.readDistributedFilesystemList();
    }

    public static void main(String[] args) throws Exception {
        //if (System.getSecurityManager() == null) {
            //System.setSecurityManager(new RMISecurityManager());
        //}

        //String name = "rmi://localhost/FileSearch";
        //try {
            //RFSInterface engine = new RFSServer();

            //[>complete this method<]

            //Naming.rebind(name, engine);
            //System.out.println("FileSearch Service bound");
        //} catch (Exception e) {
            //System.err.println("FolderSearch exception: " +
                       //e.getMessage());
            //e.printStackTrace();
        //}

        RFSServer server = new RFSServer();
        HashMap<String, Vector<FileItem>> result = server.executeQuery("/");
        for (Map.Entry<String, Vector<FileItem>> filesystem : result.entrySet()) {
            String name = filesystem.getKey();
            Vector<FileItem> files = filesystem.getValue();
            for (FileItem file : files) {
                System.out.println(name + ": " + file);
            }
        }
    }

    @Override
    public HashMap<String, Vector<FileItem>> executeQuery(String path) throws RemoteException {
        HashMap<String, Vector<FileItem>> result = new HashMap<>();

        for (String filesystem : fsIndex) {
            Filesystem fs = new Filesystem(fileSystemPath+filesystem);
            fs.printFilesystem();
        }

        return result;
    }
}

class Filesystem {
    public static class Entry {
        Entry parent;

        FileItem file;
        Vector<Entry> dir = new Vector<>();
    }

    Entry root = new Entry();

    public Filesystem(String path) {
        for (FileItem f : FileUtility.readFS(path)){
            addFile(f);
        }
    }

    private void addFile(FileItem file) {
        if (file.getParentDirectoryName() == null) {
            root.file = file;
        } else {
            Entry parent = getDirectoryByName(file.getParentDirectoryName());
            if (parent != null) {
                Entry entry = new Entry();
                entry.parent = parent;
                entry.file = file;
                parent.dir.add(entry);
            }
        }
    }

    private Entry getDirectoryByName(String name) {
        ArrayDeque<Entry> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (queue.size() != 0) {
            Entry entry = queue.removeFirst();

            if (entry.file.getName().equals(name)) {
                return entry;
            }

            if (entry.file.getFileType() == FileItemType.DIR) {
                for (Entry subEntry : entry.dir) {
                    queue.addLast(subEntry);
                }
            }
        }

        return null;
    }

    public void printFilesystem() {
        printFilesystemR(root, 0);
    }

    private void printFilesystemR(Entry entry, int level) {
        StringBuffer sb = new StringBuffer();
        int indentLength = 4;
        for (int i = 0; i < level * indentLength; ++i) {
            sb.append(' ');
        }
        sb.append(entry.file.getName());
        System.out.println(sb.toString());

        if (entry.file.getFileType() == FileItemType.DIR) {
            for (Entry subEntry : entry.dir) {
                printFilesystemR(subEntry, level + 1);
            }
        }
    }
}
