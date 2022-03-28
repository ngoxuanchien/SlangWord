/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangwords;

/**
 *
 * @author ngoxu
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import slangwords.SlangWord;



public class FileManager {
    public final static String ORIGINAL_FILE = "original.txt";
    public final static String DATA_FILE = "slangWord.txt";
    public final static String HISTORY_FILE = "history.txt";
    
    public static boolean exist(String fileName) {
        return (new File(fileName)).isFile();
    }
    
    public static SlangWordList importSlangWords(String fileName) throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(new File(fileName)));
            
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " does not exist");
            return null;
        }
        
        SlangWordList slangWordList = new SlangWordList();
        reader.readLine();
        String line = reader.readLine();
        try {
            while (line != null && !line.isEmpty()) {
                slangWordList.addSlangWord(new SlangWord(line));
                line = reader.readLine();
            }
        } catch (Exception num) {
            System.out.print("File's format is incorrect");
            reader.close();
            return null;
        }
        reader.close();
        return slangWordList;
        
    }
    
    public static SlangWordList loadSlangWordList(String fileName) throws IOException {
            DataInputStream in;
            try {
                in = new DataInputStream(new FileInputStream(new File(fileName)));
            } catch (FileNotFoundException e) {
                return null;
            }
            
            SlangWordList swList = new SlangWordList();
            
            while (true) {
                try {
                    SlangWord slangWord = new SlangWord();
                    slangWord.slang = in.readUTF();

                    int meaningCount = in.readInt();
                    slangWord.meanings = new ArrayList<String>();
                    for (int i = 0; i < meaningCount; i++) {
                        slangWord.meanings.add(in.readUTF());
                    }
                    swList.addSlangWord(slangWord);
                } catch (EOFException eof) {
                    break;
                }
        }          
        in.close();
        return swList;
    }
    
    public static void saveSlangWordList(String fileName, SlangWordList slangWordList) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(fileName)));
        
        for (Map.Entry<String, List<String>> sw : slangWordList.getEntrySet()) {
            out.writeUTF(sw.getKey());
            out.writeInt(sw.getValue().size());
            for (String s : sw.getValue()) 
                out.writeUTF(s);
        }
        
        out.close();
    }
    
    public static void addHistory(SlangWord sw) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(HISTORY_FILE), true));
        
        out.writeUTF(sw.slang);
        out.write(sw.meanings.size());
        for (String s : sw.meanings) {
            out.writeUTF(s);
        }
        out.close();
    }
    
    public static void showHistory() throws IOException {
        DataInputStream in;
        try {
            in = new DataInputStream(new FileInputStream(new File(HISTORY_FILE)));
            List<SlangWord> historyList = new ArrayList<SlangWord>();
            
            while (true) {
                try {
                    SlangWord slangWord = new SlangWord();
                    slangWord.slang = in.readUTF();
                    
                    int meaningCount = in.readInt();
                    slangWord.meanings = new ArrayList<String>();
                    for (int i = 0; i < meaningCount; i++) {
                        slangWord.meanings.add(in.readUTF());
                    }
                    historyList.add(slangWord);
                } catch (EOFException eof) {
                    break;
                }
            }
            
            System.out.print("\nSearch history: ");
            for (SlangWord sw : historyList) {
                System.out.print(sw);
            }
            in.close();
                
        } catch (FileNotFoundException e) {
            System.out.println("History is empty");
        }
    }
}
