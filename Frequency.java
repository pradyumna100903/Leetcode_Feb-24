class Solution {
    public String frequencySort(String s) {
        var map = new int[128][2];

    for (var i=0; i<128; i++)
      map[i][0] = i;

    for (var c : s.toCharArray())
      map[c][1]++;

    Arrays.sort(map, (a, b) -> Integer.compare(b[1], a[1]));

    var sb = new StringBuilder();

    for (var i=0; i<128; i++)
      while (map[i][1]-- > 0)
        sb.append((char) map[i][0]);

    return sb.toString();
    }
}
