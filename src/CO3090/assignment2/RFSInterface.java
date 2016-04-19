package CO3090.assignment2;

import java.util.HashMap;
import java.util.Vector;

public interface RFSInterface extends java.rmi.Remote {
    /**
     * List all the files located in the `path` of all the filesystems.
     *
     * @param path the path of filesystem you want to list
     * @return return all the files locaed in the `path` among the filesystems,
     *         the key of HashMap is the name of filesystem and the value is
     *         corresponding files.
     */
    public HashMap<String, Vector<FileItem>> executeQuery(String path)
        throws java.rmi.RemoteException;
}
