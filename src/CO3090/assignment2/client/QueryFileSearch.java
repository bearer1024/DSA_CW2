package CO3090.assignment2.client;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.Map.Entry;

import CO3090.assignment2.FileItem;
import CO3090.assignment2.SearchCriteria;

//Question 3.1

/*
 *
 *  Given a file, QueryFileSerach should return the
 *  full paths (absolute path to your root directory)
 *  of the given file, if it exists on one of the file
 *  servers. If more than one file with the given name
 *  is found then the result should include all paths.
 *
 *  For example:
 *
 *  Given the directory structure in
 *  RemoteFilesystem1.txt and RemoteFilesystem2.txt.
 *  (inside filesystems folder on the RMI server)
 *  When searching for “hello.txt”, RFSServer should
 *  return:
 *
 *  RemoteFilesystem1://A/C/E/hello.txt
 *  RemoteFilesystem2://A/B/hello.txt
 *  RemoteFilesystem2://A/C/E/hello.txt
 *  RemoteFilesystem2://A/C/E/F/hello.txt
 *
 *
 *
 */

public class QueryFileSearch implements SearchCriteria {
    String keyword;

    QueryFileSearch(String keyword){
        this.keyword=keyword;
    }

    @Override
    public Object /*change to your own type*/
         execute(Object /*change to your own arguments*/ obj) {

            return null;
    }
}
