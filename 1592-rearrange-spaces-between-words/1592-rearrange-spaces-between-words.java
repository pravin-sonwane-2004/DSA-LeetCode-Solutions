class Solution {
    // WTF i did this is not required
    // public String reorderSpaces(String text) {
    //     text = text.trim();
    //     String [] cArr = text.split(" ");
    //     int count = 0;
    //     for(String s : cArr) {
    //         count++;
    //     }
    //     return count-1;
    // }
   public String reorderSpaces(String text) {
    int totalSpaces = 0;
    for (char c : text.toCharArray()) {
        if (c == ' ') {
            totalSpaces++;
        }
    }
    String[] words = text.trim().split("\\s+");
    int wordCount = words.length;

    StringBuilder sb = new StringBuilder();

    if (wordCount == 1) {
        sb.append(words[0]);
        sb.append(" ".repeat(totalSpaces));
        return sb.toString();
    }

    int spacesBetween = totalSpaces / (wordCount - 1);
    int extraSpaces = totalSpaces % (wordCount - 1);

    for (int i = 0; i < wordCount; i++) {
        sb.append(words[i]);
        if (i < wordCount - 1) {
            sb.append(" ".repeat(spacesBetween));
        }
    }
    sb.append(" ".repeat(extraSpaces));

    return sb.toString();
}
}