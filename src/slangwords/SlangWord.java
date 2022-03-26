/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangwords;

/**
 *
 * @author ngoxu
 */

import java.util.*;

public class SlangWord {
    public String slang;
    public List<String> meanings;
    
    public SlangWord(String line) {
        String[] slangData = line.split("`");
        slang = slangData[0];
        meanings = Arrays.asList(slangData[1].split("\\| "));
    }
    
    public SlangWord(String slang, List<String> meanings) {
        this.slang = slang;
        this.meanings = meanings;
    }
    
    public SlangWord() {
        meanings = new ArrayList<String>();
    }
    
    public String toString() {
        String str = "Slang: " +  this.slang + "\nMeanings: ";
        for (int i = 0; i < meanings.size(); i++) {
            str += this.meanings.get(i) + (i < meanings.size() - 1 ? "| " : "");
        }
        return str;
    }
}
