class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> meetingMap = new HashMap<>();

        for (int[] meeting : meetings) {
            meetingMap.computeIfAbsent(meeting[0], key -> new ArrayList<>()).add(new int[]{meeting[2], meeting[1]});
            meetingMap.computeIfAbsent(meeting[1], key -> new ArrayList<>()).add(new int[]{meeting[2], meeting[0]});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{firstPerson, 0});

        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = earliest[firstPerson] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            int time = current[1];

            for (int[] neighbor : meetingMap.getOrDefault(person, Collections.emptyList())) {
                int t = neighbor[0];
                int nextPerson = neighbor[1];

                if (t >= time && earliest[nextPerson] > t) {
                    earliest[nextPerson] = t;
                    queue.offer(new int[]{nextPerson, t});
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earliest[i] != Integer.MAX_VALUE) {
                result.add(i);
            }
        }

        return result;
    }
}
