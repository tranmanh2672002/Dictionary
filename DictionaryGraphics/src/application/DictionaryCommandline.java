package application;

import java.util.Scanner;

public class DictionaryCommandline extends Dictionary {
    public void showAllWords() {
        System.out.format("%-3s %-15s %-50s\n", "No", "| English", "| Vietnamese");
        for (int i = 0; i < listWord.size(); i++) {
            System.out.format("%-3s %-15s %-50s\n",
                    (i + 1),
                    "| " + listWord.get(i).getWordTarget(),
                    "| " + listWord.get(i).getWordExplain());
        }
    }

    public void dictionarySearcher() {
        System.out.println("Nhập kí tự hoặc từ: ");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine().toLowerCase();
        System.out.format("%-3s %-15s %-50s\n", "No", "| English", "| Vietnamese");
        int i = 0;
        int idx = listWord.size();
        for (Word iWord : listWord) {
            String w = iWord.getWordTarget().toLowerCase();

            if (w.contains(search)) {
                System.out.format("%-3s %-15s %-50s\n",
                        (++i),
                        "| " + iWord.getWordTarget(),
                        "| " + iWord.getWordExplain());
                idx--;
            }
        }
        if (idx == listWord.size()) {
            System.out.println("Từ bạn cần tìm không có sãn!");
            System.out.println("Thêm từ này vào danh sách(Y/N)?");
            String answer = (scanner.nextLine()).toUpperCase();
            if (answer.equals("Y")){
                System.out.println("Nhập nghĩa của từ: " + search);
                String searchExplain = scanner.nextLine();
                Word newWord = new Word();
                newWord.setWordTarget(search);
                newWord.setWordExplain(searchExplain);
                listWord.add(newWord);
            }
            else {
                return;
            }

        }
    }
}

