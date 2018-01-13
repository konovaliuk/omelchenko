package ua.company.controller.pagination;

import org.apache.log4j.Logger;
import ua.company.controller.config.AppManager;
import ua.company.service.logger.MyLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Pagination.java -
 *
 * @author Ruslan Omelchenko
 * @version 1.0 07.01.2018
 */
public class PaginationHelper {
    private static final Logger LOGGER = MyLogger.getLOGGER(PaginationHelper.class);
    private int entriesPerPage;
    private int currentPage = 1;
    private int numberPages;
    private int numberRecords;
    private List pageNumbers;
    private int offset;

    private TreeMap<String, Double> partResultByLogin;

    public PaginationHelper(int numberRecords, String requestedPage) {
        this.numberRecords = numberRecords;
        init(numberRecords, requestedPage);
    }

    public void init(int numberRecords, String requestedPage){
        LOGGER.info("Initialization of pagination");
        entriesPerPage = Integer.parseInt(AppManager.getInstance().getProperty(AppManager.getDefaultRecordsPerPage()));
        numberPages = (int) Math.ceil((double) numberRecords / entriesPerPage);

        if (requestedPage!=null){
            currentPage = Integer.parseInt(requestedPage);
        }

        if (currentPage > 1 && currentPage > numberPages) {
            currentPage = numberPages;
        }
    }

    public int getOffset() {
        return (currentPage - 1) * entriesPerPage;
    }

    /**
     * Method create a list of pages for pagination
     *
     * @return List with page numbers
     */
    public List <Integer> getPages(){
        pageNumbers = new ArrayList();
        for (int i = 1; i <= numberPages; i++) {
            pageNumbers.add(new Integer(i));
        }
        return pageNumbers;
    }

    public TreeMap getMapByOffsetAndLength(TreeMap<String, Double> resultByLogin){
        partResultByLogin = new TreeMap<>();
        offset = getOffset();
        Object[] key = resultByLogin.keySet().toArray();

        int to = offset + entriesPerPage;
        if (offset > numberRecords){
            offset = numberRecords;
        }

        if (to > numberRecords){
            to = numberRecords;
        }

        for (int i = offset; i < to; i++) {
            partResultByLogin.put(key[i].toString(),resultByLogin.get(key[i]));
        }
        return partResultByLogin;
    }
}
