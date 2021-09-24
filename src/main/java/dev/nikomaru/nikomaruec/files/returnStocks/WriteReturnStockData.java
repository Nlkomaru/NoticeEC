package dev.nikomaru.nikomaruec.files.returnStocks;

import dev.nikomaru.nikomaruec.NikomaruEC;
import dev.nikomaru.nikomaruec.files.MakeFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class WriteReturnStockData {
	public static void saveData () {
		String dir = "plugins\\NikomaruEC";
		String path = "plugins\\NikomaruEC\\returnStock.dat";
		
		HashMap<UUID,List<List<Object>>> returnStock = NikomaruEC.getReturnStocks ();
		
		MakeFile.makeFile(dir,path);
		
		
		try {
			ObjectOutputStream objOutStream = new ObjectOutputStream(new FileOutputStream (path));
			SerializableReturnStock srs = new SerializableReturnStock(returnStock);
			
			objOutStream.writeObject(srs);
			objOutStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}