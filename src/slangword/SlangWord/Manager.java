/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangword.SlangWord;

/**
 *
 * @author ngoxu
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager {
    
    public final static String ORIGINAL_FILE = "orginal.data";
    public final static String DATA_FILE = "slangWord.data";
    public final static String HISTORY_FILE = "history.data";
    
    public static boolean exits(String filename) {
        return (new FILE(filename)).isFile();
    }
    
    public static SlangWordList 
}
