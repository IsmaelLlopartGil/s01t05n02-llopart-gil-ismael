package edu.n5.exercise_1;

public class Iu {

	public static void main(String[] args) {
		
		switch (args.length) {

		case 1:

			switch (args[0]) {

			case "list":
				System.out.println("list: Cal ruta.");
				
				break;
				
			case "savelist":
				PropertiesHandler propertiesHandler=new PropertiesHandler();
				SaveListCommand saveListCommand = new SaveListCommand(propertiesHandler.getProperty("read_directory"));
				saveListCommand.run();
				break;

			default:
				System.out.println("Comanda desconeguda.");
			}

			break;

		case 2:

			switch (args[0]) {

			case "list":
				ListCommand listCommand = new ListCommand(args[1]);
				listCommand.run();
				break;
				
			case "savelist":
				SaveListCommand saveListCommand = new SaveListCommand(args[1]);
				saveListCommand.run();
				break;

			default:
				System.out.println("Comanda desconeguda.");
			}

			break;
			
		default:
			System.out.println("Comanda desconeguda.");

		}
	}
}
