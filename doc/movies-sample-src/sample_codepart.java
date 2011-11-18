public class Main {
	public void a() {
	Database db = Database.loadDatabase(“mydb.gdf”);
	Node me = db.getNode(0);
	//. . .
	Transaction t = new Transaction();
	t.setRootNode(me);
	t.addQuery(1, db.getEdgeType(MySchema.EDGE_FOLLOWS));
	t.addQuery(1, db.getEdgeType(MySchema.EDGE_LIKE));
	t.addQuery(2, db.getEdgeType(MySchema.EDGE_WATCHED));
	t.minus(1, 2);
	t.execute();

	if (t.isSuccessfull()) {
	    NodeSet result = t.getResultSet();
	    //. . .
	} else {
	    System.out.println("Transaction wasn't executed!");
	}

	//. . .
	db.close();	// Close database after using
	}
}
