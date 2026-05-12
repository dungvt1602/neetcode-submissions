class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String a : strs)
        {
            result.append(a.length() + "#" + a);
        }
        return result.toString();
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        int i = 0;
        while(i<str.length())
        {
            int j = i;
            while(str.charAt(j) != '#')
            {
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            String item = str.substring(j+1,j+1+len);
            result.add(item);
            i = j+1+len;
        }

        return result;

    }
}
