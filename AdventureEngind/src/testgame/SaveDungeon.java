package testgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import data.ConcreteDungeon;
import data.IDungeon;
import data.IRoom;
import data.rooms.achmere.AchmereInterior;
import data.rooms.outsidewhitehouse.ConstitutionAndFifteenth;
import data.rooms.outsidewhitehouse.ConstitutionAndWashingMonument;
import data.rooms.outsidewhitehouse.FifteenthAndEastStreet;
import data.rooms.outsidewhitehouse.FifteenthAndLayafettePark3;
import data.rooms.outsidewhitehouse.FifteenthAndWashingtonMonument;
import data.rooms.outsidewhitehouse.IndependenceAndFifteenth;
import data.rooms.outsidewhitehouse.IndependenceAndWashingtonMonument;
import data.rooms.outsidewhitehouse.LayafettePark2;
import data.rooms.outsidewhitehouse.LayafettePark3;
import data.rooms.outsidewhitehouse.LayafettePark4;
import data.rooms.outsidewhitehouse.LayafettePark5;
import data.rooms.outsidewhitehouse.LyafettePark1;
import data.rooms.outsidewhitehouse.LyafettePark6;
import data.rooms.outsidewhitehouse.SeventeenthAndConstitution;
import data.rooms.outsidewhitehouse.SeventeenthAndIndependence;
import data.rooms.outsidewhitehouse.SeventeenthAndLayafettePark1;
import data.rooms.outsidewhitehouse.SeventeenthAndPennsylvania;
import data.rooms.outsidewhitehouse.SeventeenthAndSouthPlazaNorthWest;
import data.rooms.outsidewhitehouse.SeventeenthAndWashingtonMonument;
import data.rooms.outsidewhitehouse.SouthPlNW;
import data.rooms.outsidewhitehouse.WashingtonMonument;
import data.rooms.outsidewhitehouse.WhiteHouseAlly;
import data.rooms.outsidewhitehouse.WhiteHouseFront;
import data.rooms.pennave.BackAlly;
import data.rooms.pennave.NinteenthStreet;
import data.rooms.pennave.OnComingTraffic;
import data.rooms.pennave.OutsideAchmeres;
import data.rooms.pennave.OutsideBar;
import data.rooms.pennave.OutsidePrison;
import data.rooms.pennave.PennAve1;
import data.rooms.pennave.PennAve3;
import data.rooms.pennave.PennAve4;
import data.rooms.pennave.PennAve5;
import data.rooms.pennave2.PennAve2;
import data.rooms.prisoninterior.Interior1;
import data.rooms.prisoninterior.Interior2;

public class SaveDungeon {
	public static void main(String[] args){
		savePennAveDungeon();
		saveAchmereDungeon();
		saveOutsideWhiteHouse();
		savePrisonInterior();
	}
	
	private static void savePrisonInterior(){
		IDungeon prisonInterior = new ConcreteDungeon();
		IRoom interior1 = new Interior1();
		IRoom interior2 = new Interior2();
		
		prisonInterior.addRoom(interior1);
		prisonInterior.addRoom(interior2);
		
		prisonInterior.setTopMapping(interior1, interior2);
		prisonInterior.setBottomMapping(interior2, interior1);
		
		prisonInterior.setCurrentRoom(interior1);
		
		String fileName = "."+File.separatorChar+"rooms"+File.separatorChar+"prisoninterior.dgn";
		prisonInterior.setFileName(fileName);
		ObjectOutputStream outputStream;
		try {
			
			outputStream = new ObjectOutputStream(new FileOutputStream(prisonInterior.getFileName()));
			outputStream.writeObject(prisonInterior);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static void saveOutsideWhiteHouse(){
		IDungeon dungeon = new ConcreteDungeon();
		IRoom pennAndSeventeenth = new SeventeenthAndPennsylvania();
		dungeon.addRoom(pennAndSeventeenth);
		
		IRoom seventeenthAndSouth = new SeventeenthAndSouthPlazaNorthWest();
		dungeon.addRoom(seventeenthAndSouth);
		
		IRoom seventeenthAndL1 = new SeventeenthAndLayafettePark1();
		dungeon.addRoom(seventeenthAndL1);
		
		IRoom constitutionAndSeventeenth = new SeventeenthAndConstitution();
		dungeon.addRoom(constitutionAndSeventeenth);
		
		IRoom seventeenthAndWashingtonMonument = new SeventeenthAndWashingtonMonument();
		dungeon.addRoom(seventeenthAndWashingtonMonument);
		
		IRoom seventeenthAndIndependence = new SeventeenthAndIndependence();
		dungeon.addRoom(seventeenthAndIndependence);
		
		IRoom independenceAndWashingtonMonument = new IndependenceAndWashingtonMonument();
		dungeon.addRoom(independenceAndWashingtonMonument);
		
		IRoom layafettePark6 = new LyafettePark6();
		dungeon.addRoom(layafettePark6);
		
		IRoom layafettePark1 = new LyafettePark1();
		dungeon.addRoom(layafettePark1);
		
		IRoom southPlazaNW = new SouthPlNW();
		dungeon.addRoom(southPlazaNW);
		
		IRoom whiteHouseAlly = new WhiteHouseAlly();
		dungeon.addRoom(whiteHouseAlly);
		
		IRoom whiteHouseFront = new WhiteHouseFront();
		dungeon.addRoom(whiteHouseFront);
		
		IRoom layafettePark2 = new LayafettePark2();
		dungeon.addRoom(layafettePark2);
		
		IRoom layafettePark5 = new LayafettePark5();
		dungeon.addRoom(layafettePark5);
		
		IRoom constitutionAndMonument = new ConstitutionAndWashingMonument();
		dungeon.addRoom(constitutionAndMonument);
		
		IRoom washingtonMonument = new WashingtonMonument();
		dungeon.addRoom(washingtonMonument);
		
		IRoom layafettePark4 = new LayafettePark4();
		dungeon.addRoom(layafettePark4);
		
		IRoom layafettePark3 = new LayafettePark3();
		dungeon.addRoom(layafettePark3);
		
		IRoom independenceAndFifteenth = new IndependenceAndFifteenth();
		dungeon.addRoom(independenceAndFifteenth);
		
		IRoom fifteenthAndWashingtonMonument = new FifteenthAndWashingtonMonument();
		dungeon.addRoom(fifteenthAndWashingtonMonument);
		
		IRoom constitutionAndFifteenth = new ConstitutionAndFifteenth();
		dungeon.addRoom(constitutionAndFifteenth);
		
		IRoom fifteenthAndL3 = new FifteenthAndLayafettePark3();
		dungeon.addRoom(fifteenthAndL3);
		
		IRoom fifteenthAndEastStreet = new FifteenthAndEastStreet();
		dungeon.addRoom(fifteenthAndEastStreet);
		
		dungeon.setBottomMapping(pennAndSeventeenth, seventeenthAndSouth);
		
		dungeon.setTopMapping(seventeenthAndSouth, pennAndSeventeenth);
		dungeon.setBottomMapping(seventeenthAndSouth, seventeenthAndL1);
		dungeon.setRightMapping(seventeenthAndSouth, southPlazaNW);
		
		dungeon.setTopMapping(seventeenthAndL1, seventeenthAndSouth);
		dungeon.setBottomMapping(seventeenthAndL1, constitutionAndSeventeenth);
		dungeon.setRightMapping(seventeenthAndL1, layafettePark1);
		
		dungeon.setTopMapping(constitutionAndSeventeenth, seventeenthAndL1);
		dungeon.setRightMapping(constitutionAndSeventeenth, constitutionAndMonument);
		dungeon.setBottomMapping(constitutionAndSeventeenth, seventeenthAndWashingtonMonument);
		
		dungeon.setTopMapping(constitutionAndMonument, constitutionAndSeventeenth);
		dungeon.setRightMapping(constitutionAndMonument, washingtonMonument);
		dungeon.setBottomMapping(constitutionAndMonument, seventeenthAndIndependence);
		
		dungeon.setTopMapping(seventeenthAndIndependence, seventeenthAndWashingtonMonument);
		dungeon.setRightMapping(seventeenthAndIndependence, independenceAndWashingtonMonument);
		
		dungeon.setLeftMapping(independenceAndWashingtonMonument, seventeenthAndIndependence);
		dungeon.setRightMapping(seventeenthAndWashingtonMonument, seventeenthAndIndependence);
		
		dungeon.setRightMapping(layafettePark6, layafettePark5);
		dungeon.setTopMapping(layafettePark6, layafettePark1);
		
		dungeon.setLeftMapping(layafettePark1, seventeenthAndL1);
		dungeon.setRightMapping(layafettePark1, layafettePark2);
		dungeon.setBottomMapping(layafettePark1, layafettePark6);
		
		dungeon.setLeftMapping(southPlazaNW, seventeenthAndSouth);
		dungeon.setRightMapping(southPlazaNW, whiteHouseFront);
		dungeon.setTopMapping(southPlazaNW, whiteHouseAlly);
		
		dungeon.setBottomMapping(whiteHouseAlly, southPlazaNW);
		
		dungeon.setLeftMapping(whiteHouseFront, southPlazaNW);
		dungeon.setRightMapping(whiteHouseFront, fifteenthAndEastStreet);
		dungeon.setBottomMapping(whiteHouseFront, layafettePark2);
		
		dungeon.setTopMapping(layafettePark2, whiteHouseFront);
		dungeon.setLeftMapping(layafettePark2, layafettePark1);
		dungeon.setRightMapping(layafettePark2, layafettePark3);
		dungeon.setBottomMapping(layafettePark2, layafettePark5);
		
		dungeon.setTopMapping(layafettePark5, layafettePark2);
		dungeon.setLeftMapping(layafettePark5, layafettePark6);
		dungeon.setRightMapping(layafettePark5, layafettePark4);
		
		dungeon.setLeftMapping(constitutionAndMonument, constitutionAndSeventeenth);
		dungeon.setRightMapping(constitutionAndMonument, constitutionAndFifteenth);
		dungeon.setBottomMapping(constitutionAndMonument, washingtonMonument);
		
		dungeon.setTopMapping(washingtonMonument, constitutionAndMonument);
		dungeon.setLeftMapping(washingtonMonument, seventeenthAndWashingtonMonument);
		dungeon.setRightMapping(washingtonMonument, fifteenthAndWashingtonMonument);
		dungeon.setBottomMapping(washingtonMonument, independenceAndWashingtonMonument);
		
		dungeon.setLeftMapping(independenceAndFifteenth, independenceAndWashingtonMonument);
		dungeon.setTopMapping(independenceAndFifteenth, fifteenthAndWashingtonMonument);
		
		dungeon.setLeftMapping(fifteenthAndWashingtonMonument, washingtonMonument);
		dungeon.setBottomMapping(fifteenthAndWashingtonMonument, independenceAndFifteenth);
		dungeon.setTopMapping(fifteenthAndWashingtonMonument, constitutionAndFifteenth);
		
		dungeon.setBottomMapping(constitutionAndFifteenth, fifteenthAndWashingtonMonument);
		dungeon.setLeftMapping(constitutionAndFifteenth, constitutionAndMonument);
		dungeon.setTopMapping(constitutionAndFifteenth, fifteenthAndL3);
		
		dungeon.setLeftMapping(fifteenthAndL3, layafettePark3);
		dungeon.setBottomMapping(fifteenthAndL3, constitutionAndFifteenth);
		dungeon.setTopMapping(fifteenthAndL3, fifteenthAndEastStreet);
		
		dungeon.setLeftMapping(fifteenthAndEastStreet, whiteHouseFront);
		dungeon.setBottomMapping(fifteenthAndEastStreet, fifteenthAndL3);
		
		dungeon.setLeftMapping(layafettePark3, layafettePark2);
		dungeon.setRightMapping(layafettePark3, fifteenthAndL3);
		dungeon.setBottomMapping(layafettePark3, layafettePark4);
		
		dungeon.setTopMapping(layafettePark4, layafettePark3);
		dungeon.setLeftMapping(layafettePark4, layafettePark5);
		
		dungeon.setCurrentRoom(pennAndSeventeenth);
		dungeon.setInitialRoom(pennAndSeventeenth);
		
		String fileName = "."+File.separatorChar+"rooms"+File.separatorChar+"whitehouseexterior.dgn";
		dungeon.setFileName(fileName);
		ObjectOutputStream outputStream;
		try {
			
			outputStream = new ObjectOutputStream(new FileOutputStream(dungeon.getFileName()));
			outputStream.writeObject(dungeon);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void saveAchmereDungeon(){
		IDungeon dungeon = new ConcreteDungeon();
		IRoom achmere1 = new AchmereInterior();
		dungeon.addRoom(achmere1);
		dungeon.setCurrentRoom(achmere1);
		dungeon.setInitialRoom(achmere1);
		String fileName = "."+File.separatorChar+"rooms"+File.separatorChar+"achmere.dgn";
		dungeon.setFileName(fileName);
		ObjectOutputStream outputStream;
		try {
			
			outputStream = new ObjectOutputStream(new FileOutputStream(dungeon.getFileName()));
			outputStream.writeObject(dungeon);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void savePennAveDungeon() {
		IDungeon dungeon = new ConcreteDungeon();
		IRoom penn1 = new PennAve1();
		IRoom penn2 = new PennAve2();
		IRoom backAlly = new BackAlly();
		IRoom traffic = new OnComingTraffic();
		IRoom prison = new OutsidePrison();
		IRoom penn3 = new PennAve3();
		IRoom ninteenthStreet = new NinteenthStreet();
		IRoom outsideAchmeres = new OutsideAchmeres();
		IRoom penn4 = new PennAve4();
		IRoom outsideBar = new OutsideBar();
		IRoom penn5 = new PennAve5();
		
		dungeon.addRoom(penn1);
		dungeon.addRoom(penn2);
		dungeon.addRoom(backAlly);
		dungeon.addRoom(traffic);
		dungeon.addRoom(prison);
		dungeon.addRoom(penn3);
		dungeon.addRoom(ninteenthStreet);
		dungeon.addRoom(outsideAchmeres);
		dungeon.addRoom(penn4);
		dungeon.addRoom(outsideBar);
		dungeon.addRoom(penn5);
		
		dungeon.setBottomMapping(backAlly, penn1);
		
		dungeon.setBottomMapping(penn1, penn2);
		dungeon.setLeftMapping(penn1, traffic);
		dungeon.setTopMapping(penn1, backAlly);
		dungeon.setRightMapping(penn1, penn2);
		
		dungeon.setBottomMapping(penn2, prison);
		dungeon.setLeftMapping(penn2, penn1);
		dungeon.setRightMapping(penn2, penn3);
		
		dungeon.setLeftMapping(penn3, penn2);
		dungeon.setTopMapping(penn3, ninteenthStreet);
		dungeon.setRightMapping(penn3, penn4);
		
		dungeon.setBottomMapping(traffic, penn1);
		dungeon.setCurrentRoom(penn2);
		dungeon.setInitialRoom(penn2);
		dungeon.setTopMapping(prison, penn2);
		
		dungeon.setBottomMapping(ninteenthStreet, penn3);
		dungeon.setTopMapping(ninteenthStreet, outsideAchmeres);
		
		dungeon.setBottomMapping(outsideAchmeres, ninteenthStreet);
		
		dungeon.setLeftMapping(penn4, penn3);
		dungeon.setTopMapping(penn4, outsideBar);
		dungeon.setRightMapping(penn4, penn5);
		
		dungeon.setBottomMapping(outsideBar, penn4);
		dungeon.setLeftMapping(penn5, penn4);
		
		ObjectOutputStream outputStream;
		String fileName = "."+File.separatorChar+"rooms"+File.separatorChar+"testdungeon.dgn";
		dungeon.setFileName(fileName);
		try {
			
			outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
			outputStream.writeObject(dungeon);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
