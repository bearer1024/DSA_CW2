package CO3090.assignment2.client;
import CO3090.assignment2.*;

import java.rmi.*;
import java.util.HashMap;

public class RFSClient {
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }

        try {
            String name = "rmi://localhost/FolderSearch";
            RFSInterface comp = (RFSInterface) Naming.lookup(name);

            //Question (4.1) and (4.2)
            /*complete this method*/
            SearchCriteria query;
            Object result = comp.executeQuery(query);
        } catch (Exception e) {
            System.err.println("exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
