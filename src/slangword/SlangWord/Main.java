/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slangword.SlangWord;

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
    public static void main(String[] args) {
        SlangWordList slangWordList;
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
    }
    
}
