package ua.company.controller.pagination;

import org.apache.log4j.Logger;
import ua.company.controller.config.AppManager;
import ua.company.service.logger.MyLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * PaginationHelper.java - divide the list of records for display by pages.
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

    /**
     * Constructor - creation new object of class {@link PaginationHelper} with parameters
     *
     * @param numberRecords number of records in the list which is displayed
     * @param requestedPage page which user want to see
     */
    public PaginationHelper(int numberRecords, String requestedPage) {
        this.numberRecords = numberRecords;
        init(numberRecords, requestedPage);
    }

    /**
     * Initialize class {@link PaginationHelper}, receive number of entries which will be displayed
     * from class {@link AppManager}, calculate number of pages.
     *
     * @param numberRecords number of records in the list which is displayed
     * @param requestedPage page which user want to see
     */
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

    /**
     * Initialize class {@link PaginationHelper}, receive number of entries which will be displayed
     * from class {@link AppManager}, calculate number of pages.
     *
     * @return position in the list from which entries will be displayed.
     */
    public int getOffset() {
        return (currentPage - 1) * entriesPerPage;
    }

    /**
     * Create a list of pages for partial display of records.
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

    /**
     * Display to user requested part of students results.
     *
     * @param resultByLogin received results of students
     * @return the map of records which must be displayed to user
     */
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
