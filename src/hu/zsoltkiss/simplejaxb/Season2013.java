package hu.zsoltkiss.simplejaxb;


import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Season2013 {

	public static void main(String[] args) {
		
		InputStream is = null;

		Team khfc = new Team();
		khfc.setName("Kispest Honved");
		khfc.setOfficialName("Budapesti Honved Footbal Club Kft.");
		khfc.setYearOfFoundation(1913);

		try {
			JAXBContext jc = JAXBContext.newInstance(Team.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			// marshaller.marshal(khfc, new File("C:\\myteam.xml"));
			marshaller.marshal(khfc, System.out);

		} catch (JAXBException jaxbe) {
			jaxbe.printStackTrace();
		}

		System.out.println("--------------------------------------------");

		try {
			JAXBContext jc = JAXBContext.newInstance(Team.class, Player.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			Player dl = new Player();
			dl.setName("Davide Lanzafame");
			dl.setTeam(khfc);

			marshaller.marshal(dl, System.out);

		} catch (JAXBException jaxbe) {
			jaxbe.printStackTrace();
		}

		System.out.println("--------------------------------------------");

		try {
			JAXBContext jc = JAXBContext.newInstance(Team.class, Player.class,
					DreamTeam.class);
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			DreamTeam dt = new DreamTeam();

			Player ksz = new Player();
			ksz.setName("Kemenes Szabolcs");
			ksz.setTeam(khfc);

			Player bb = new Player();
			bb.setName("Barath Botond");
			bb.setTeam(khfc);

			Player ig = new Player();
			ig.setName("Ivancsiscs Gellert");
			ig.setTeam(khfc);

			Player dl = new Player();
			dl.setName("Davide Lanzafame");
			dl.setTeam(khfc);

			/*
			 * dt.addMember(ksz); dt.addMember(bb); dt.addMember(ig);
			 * dt.addMember(dl);
			 */

			Player[] array = new Player[] { ksz, bb, ig, dl };
			dt.setTacticalOrder(array);

			marshaller.marshal(dt, System.out);

		} catch (JAXBException jaxbe) {
			jaxbe.printStackTrace();
		}

		System.out.println("--------------------------------------------");

		try {

			is = Season2013.class.getResourceAsStream("test.xml");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Team.class,
					Player.class, DreamTeam.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			DreamTeam dreamTeam = (DreamTeam) jaxbUnmarshaller.unmarshal(is);
			System.out.println(Arrays.asList(dreamTeam.getTacticalOrder()));

		} catch (JAXBException jaxbe) {
			jaxbe.printStackTrace();
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		

	}

}
