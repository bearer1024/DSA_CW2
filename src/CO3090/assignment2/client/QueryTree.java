package CO3090.assignment2.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import CO3090.assignment2.FileItem;
import CO3090.assignment2.SearchCriteria;

//Question 3.3

/*
 * For each file server, QueryTree should return the directory
 * structure as a string formatted according to the specified
 * format.
 *
 * For example, given the directory structure in
 * RemoteFilesystem1.txt and RemoteFilesystem2.txt.
 * RFSServer should return:
 *
 * RemoteFilesystem1:
 * A{B,C{books.xls,D,E{readme.txt,hello.txt},F{G}}}
 *
 * RemoteFilesystem2:
 * A{B{hello.txt,D{abc.txt,xyz.txt}},C{E{hello.txt,F{hello.txt}}}}
 *
 *
 */

public class QueryTree implements SearchCriteria {
    @Override
    public Object /*change to your own type*/
    execute(Object /*change to your own arguments*/ obj) {
        return null;
    }
}
