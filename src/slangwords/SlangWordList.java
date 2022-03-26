/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slangwords;

/**
 *
 * @author ngoxu
 */

import java.io.IOException;
import java.util.*;

public class SlangWordList {
    private TreeMap<String, List<String>> theList;
    
    public SlangWordList() {
        theList = new TreeMap<>();
    }
    
    public SlangWord toSlangWord(Map.Entry<String, List<String>> entry) {
        return new SlangWord(entry.getKey(), entry.getValue());
    }
    
    public Set<Map.Entry<String, List<String>>> getEntrySet() {
      return theList.entrySet();  
    }
    
    public SlangWord findSlang(String slang) {
        if (theList.get(slang) == null) {
            return null;
        }
        return new SlangWord(slang, theList.get(slang));
    }
    
    public ArrayList<SlangWord> findMeaningWithKeyword(String keyword) {
        ArrayList<SlangWord> result = new ArrayList<SlangWord>();
        for (Map.Entry<String, List<String>> entry : theList.entrySet()) {
            for (int j = 0; j < entry.getValue().size(); j++) {
                if (entry.getValue().get(j).contains(keyword)) {
                    result.add(toSlangWord(entry));
                    break;
                }
            }
        }
        return result;
    }
    
    public void addSlangWord(SlangWord newSlangWord) {
        theList.put(newSlangWord.slang, newSlangWord.meanings);
    }
    
    public void duplicateSlangWord(SlangWord newSlangWord) {
        SlangWord targetSlangWord = findSlang(newSlangWord.slang);
        
        Set<String> meaningsSet = new TreeSet<String> (targetSlangWord.meanings);
        meaningsSet.addAll(newSlangWord.meanings);
        
        updateSlangWord(targetSlangWord);
    }
    
    public void updateSlangWord(SlangWord newSlangWord) {
        theList.put(newSlangWord.slang, newSlangWord.meanings);
    }
    
    public void deleteSlangWord(String slang) {
        theList.remove(slang);
    }
    
    public void resetSlangWordList() throws IOException {
        SlangWordList og = FileManager.loadSlangWordList(FileManager.ORIGINAL_FILE);
        this.theList = og.theList;
    }
    
    public SlangWord randomSlangWord() {
        List<Map.Entry<String, List<String>>> entriesArr = new ArrayList<Map.Entry<String, List<String>>>(theList.entrySet());
        return toSlangWord(entriesArr.get((new Random()).nextInt(entriesArr.size())));
    }
    
    public String toString() {
        List<SlangWord> slangWordList = new ArrayList<SlangWord>();
        for (Map.Entry<String, List<String>> entry : theList.entrySet())
            slangWordList.add(toSlangWord(entry));
        
        String result = "";
        for (SlangWord sw : slangWordList)
            result += sw.toString() + "\n";
        return result;
    }
}
