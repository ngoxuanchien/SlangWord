/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slangwords;

/**
 *
 * @author ngoxu
 */

import java.io.*;
import java.util.*;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        FileManager.clearConsole();
        /*SlangWordList slangWordList;
	Scanner sc = new Scanner(System.in);
	if (FileManager.exist(FileManager.DATA_FILE) && FileManager.exist(FileManager.ORIGINAL_FILE)) {
            slangWordList = FileManager.loadSlangWordList(FileManager.DATA_FILE);
	} else {
            do {
                System.out.print("Enter the path to slang.txt file: ");
		String path = sc.next();
                slangWordList = FileManager.importSlangWords(path);
		if (slangWordList != null) {
                    FileManager.saveSlangWordList(FileManager.ORIGINAL_FILE, slangWordList);
                    FileManager.saveSlangWordList(FileManager.DATA_FILE, slangWordList);
		}
            } while (slangWordList == null);
	}
        
        boolean exit = false;
        
        while (!exit) {
            try {
                System.out.println("\nSlangWords program");
                System.out.println("1. Search for slang word by slang.");
                System.out.println("2. Search for slang word by definition.");
                System.out.println("3. Show search history.");
                System.out.println("4. Add a slang word.");
                System.out.println("5. Eddit a slang word");
                System.out.println("6. Deletea a slang word.");
                System.out.println("7. reset back to the original list (slang.txt).");
                System.out.println("8. On this day slang word.");
                System.out.println("9. Game: Guess the definition from a slang");
                System.out.println("10. Game: Guess the slang from a definition.");
                System.out.println("0. Exit");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1: {
                        System.out.print("Enter the slang: ");
                        String slang = sc.next();
                        sc.nextLine();
                        SlangWord foundSlangWord = slangWordList.findSlang(slang);
                        if (foundSlangWord == null) {
                            System.out.println("ther isn'a slang word with the slang " + slang);
                            
                        } else {
                            System.out.println("Slang word found: \n" + foundSlangWord.toString());
                            FileManager.addHistory(foundSlangWord);
                        }
                        break;
                    }
                    case 2: {
                        System.out.println("Enter the keyword: ");
                        String key = sc.nextLine();
                        ArrayList<SlangWord> foundSlangs = slangWordList.findMeaningWithKeyword(key);
                        if (foundSlangs.size() == 0) {
                            System.out.println("There isn't any slang word with definitons that contain " + key);
                        } else {
                            System.out.println("Slang words found: \n");
                            for (SlangWord slangWord : foundSlangs) {
                                System.out.println(slangWord);
                            }
                            break;
                        }
                    }
                    case 3: {
                        FileManager.showHistory();
                        break;
                    }
                    case 4: {
                        SlangWord newSlangWord = new SlangWord();
                        
                        System.out.print("Enter new slang: ");
                        newSlangWord.slang = sc.next();
                        
                        System.out.print("Enter meanings count: ");
                        int meaningCount = sc.nextInt();
                        sc.nextLine();
                        for (int i = 0; i < meaningCount; i++) {
                            System.out.print("Enter next meaning: ");
                            newSlangWord.meanings.add(sc.nextLine());
                        }
                        
                        if (slangWordList.findSlang(newSlangWord.slang) != null) {
                            System.out.println("There is already a slang word with the slang " + newSlangWord.slang + " , do you want to overwrite(0), duplicate(D) or do nothing(N)?: ");
                            String yesNo;
                            do {
                                yesNo = sc.next();
                                sc.nextLine();
                                if (yesNo.compareTo("0") == 0) {
                                    slangWordList.updateSlangWord(newSlangWord);
                                    System.out.print("Overwrite successfully!");
                                } else if (yesNo.compareTo("D") == 0) {
                                    slangWordList.duplicateSlangWord(newSlangWord);
                                    System.out.println("Duplicate successfully!");
                                } else if (yesNo.compareTo("N") != 0) {
                                    System.out.println("Wrong input, please try again");
                                }
                            } while (yesNo.compareTo("0") != 0 && yesNo.compareTo("D") != 0 && yesNo.compareTo("N") != 0);
                        } else {
                            slangWordList.addSlangWord(newSlangWord);
                            System.out.println("Slang word added successfully!");
                        }
                        
                        FileManager.saveSlangWordList(FileManager.DATA_FILE, slangWordList);
                        break;
                    }
                    case 5: {
                        System.out.print("Enter the slang of the slang word that you want to edit: ");
                        SlangWord editedSlangWord = new SlangWord();
                        editedSlangWord.slang = sc.next();
                        if (slangWordList.findSlang(editedSlangWord.slang) == null) {
                            System.out.println("There isn't a slang word with the slang " + editedSlangWord.slang);
                            sc.nextLine();
                        } else {
                            System.out.print("Enter meanings count: ");
                            int meaningCount = sc.nextInt();
                            sc.nextLine();
                            for (int i = 0; i < meaningCount; i++) {
                                System.out.print("Enter next meaning: ");
                                editedSlangWord.meanings.add(sc.nextLine());
                            }
                            
                            slangWordList.updateSlangWord(editedSlangWord);
                            System.out.println("Slang word editted succedfully!");
                            
                            FileManager.saveSlangWordList(FileManager.DATA_FILE, slangWordList);
                        }
                        break;
                    }
                    case 6: {
                        System.out.print("Enter the slang of the slang word that you want to delete: ");
                        String slang = sc.next();
                        if (slangWordList.findSlang(slang) == null) {
                            System.out.println("There isn't a slang word with the slang: " + slang);
                            sc.nextLine();
                        } else {
                            System.out.println("Are you sure you want to delete the following slang word? (Y/N):");
                            System.out.println(slangWordList.findSlang(slang));
                            
                            String yesNo;
                            do {
                                yesNo = sc.next();
                                if (yesNo.compareTo("Y") == 0) {
                                    slangWordList.deleteSlangWord(slang);
                                    System.out.println("Delete successfully!");
                                } else if (yesNo.compareTo("N") != 0) {
                                    System.out.println("Wrong input, please try again");
                                }
                            } while (yesNo.compareTo("Y") != 0 && yesNo.compareTo("N") != 0);
                            
                            FileManager.saveSlangWordList(FileManager.DATA_FILE, slangWordList);
                            
                        }
                        break;
                    }
                    case 7: {
                        slangWordList.resetSlangWordList();
                        System.out.println("Reset successfully!");
                        FileManager.saveSlangWordList(FileManager.DATA_FILE, slangWordList);
                        break;
                    }
                    case 8: {
                        System.out.println("Today's slang word is: ");
                        System.out.println(slangWordList.randomSlangWord());
                        break;
                    }
                    case 9: {
                        SlangWord theSlangWord = slangWordList.randomSlangWord();
                        System.out.println("Guess the definiton of this slang: " + theSlangWord.slang);
                        
                        String[] choises = new String[4];
                        int theSlangWordAnswer = (new Random()).nextInt(4);
                        for (int i = 0; i < 4; i++) {
                            SlangWord thisChoiceSlangWord;
                            if (i == theSlangWordAnswer) {
                                thisChoiceSlangWord = theSlangWord;
                            } else {
                                thisChoiceSlangWord = slangWordList.randomSlangWord();
                            }
                            
                            choises[i] = thisChoiceSlangWord.meanings.get((new Random()).nextInt(thisChoiceSlangWord.meanings.size()));
                            System.out.println(Character.toString((char)('A' + i)) + ": " + choises[i]);
                        }
                        
                        char answer;
                        do {
                            answer = sc.next().charAt(0);
                            sc.nextLine();
                            if (answer >= 'A' && answer <= 'D') {
                                if (answer - 'A' == theSlangWordAnswer) {
                                    System.out.println("Correct! ");
                                } else {
                                    System.out.println("Wrong answer!");
                                }
                            } else {
                                System.out.println("Wrong input, please try again");
                            }
                        } while (answer < 'A' || answer > 'D');
                        break;
                    }
                    case 10: {
                        SlangWord theSlangWord = slangWordList.randomSlangWord();
                        System.out.println("Guess the slang of this deffinition: " + theSlangWord.meanings.get((new Random()).nextInt(theSlangWord.meanings.size())));
                        String[] choices = new String[4];
                        int theSlangWordAnswer = (new Random().nextInt(4));
                        for (int i = 0; i < 4; i++) {
                            if (i == theSlangWordAnswer) {
                                choices[i] = theSlangWord.slang;
                            } else {
                                choices[i] = slangWordList.randomSlangWord().slang;
                            }
                            System.out.println(Character.toString((char)('A' + i))+ ": " + choices[i]);
                        }
                        
                        char answer;
                        do {
                            answer = sc.next().charAt(0);
                            sc.nextLine();
                            if (answer >= 'A' && answer <= 'D') {
                                if (answer - 'A' == theSlangWordAnswer) {
                                    System.out.println("Correct!");
                                } else {
                                    System.out.println("Wrong answer!");
                                }
                            } else {
                                System.out.println("Wrong input, please try again");
                            }
                        } while (answer < 'A' || answer > 'D');
                        
                        break;
                    }
                    case 0: {
                        exit = true;
                        break;
                    }
                    default: 
                        System.out.println("Worng input, please try again");
                        break;
                }
                System.out.println("\nPress enter to continue...");
                sc.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input, please try again\n");
                sc.nextLine();
            }
        }
        sc.close();*/
    } 
}
