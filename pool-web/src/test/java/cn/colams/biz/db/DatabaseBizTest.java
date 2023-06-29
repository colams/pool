//package cn.colams.biz.db;
//
//import cn.colams.biz.dalTest;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = dalTest.class)
//@SpringBootApplication(scanBasePackages = {"cn.colams"})
//public class DatabaseBizTest {
//
////    @InjectMocks
////    DatabaseBiz databaseBiz;
//
////    @Test
////    public void getDatabaseList() throws Exception {
////        List<Map<Integer, List<String>>> list = databaseBiz.getTableTypes();
////
////        for (int i = 0; i < list.size(); i++) {
////            String line = String.format("[%s]:", i);
////            System.out.println(line + Arrays.toString(list.get(i).get(i).toArray()));
////        }
////
////    }
////
////    @Test
////    public void getCatalogs() throws Exception {
////        List<Map<Integer, List<String>>> list = databaseBiz.getCatalogs();
////
////        for (int i = 0; i < list.size(); i++) {
////            String line = String.format("[%s]:", i);
////            System.out.println(line + Arrays.toString(list.get(i).get(i).toArray()));
////        }
////    }
////
////    @Test
////    public void getTables() throws Exception {
////        List<Map<Integer, List<String>>> list = databaseBiz.getTables();
////
////        for (int i = 0; i < list.size(); i++) {
////            String line = String.format("[%s]:", i);
////            System.out.println(line + Arrays.toString(list.get(i).get(i).toArray()));
////        }
////    }
////
////    @Test
////    public void getColumns() throws Exception {
////        List<Map<Integer, List<String>>> list = databaseBiz.getColumns();
////
////        for (int i = 0; i < list.size(); i++) {
////            String line = String.format("[%s]:", i);
////            System.out.println(line + Arrays.toString(list.get(i).get(i).toArray()));
////        }
////    }
//
//}