public class MongodbTest {

//    @Test
//    public void mongtest(){
//        try{
//            // 连接到 mongodb 服务
//            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//
//            // 连接到数据库
//            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
//            System.out.println("Connect to database successfully");
////            mongoDatabase.createCollection("test");
////            System.out.println("集合创建成功");
//            MongoCollection<org.bson.Document> collection = mongoDatabase.getCollection("test");
//            System.out.println("集合 test 选择成功");
//            org.bson.Document document = new org.bson.Document("title", "MongoDB").
//                    append("description", "database").
//                    append("likes", 100).
//                    append("by", "Fly2");
//            List<Document> documents = new ArrayList<Document>();
//            documents.add(document);
//            collection.insertMany(documents);
//            System.out.println("文档插入成功");
////            collection.find()
//        }catch(Exception e){
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//        }
//    }
}
