class Solution {
    private static boolean canAssign(int mid, int[] workers, int[] tasks, int pills, int strength) {
        if (mid == 0) return true;
        if (mid > workers.length) return false;

        TreeMap<Integer, Integer> cur_workers = new TreeMap<>();
        int n = workers.length;
        for (int i = n - mid; i < n; i++) {
            cur_workers.put(workers[i], cur_workers.getOrDefault(workers[i], 0) + 1);
        }

        int used_pills = 0;
        for (int i = mid - 1; i >= 0; i--) {
            int cur_task = tasks[i];

            Integer cur_worker = cur_workers.floorKey(Integer.MAX_VALUE);

            if (cur_worker != null && cur_worker >= cur_task) {
                int cur_worker_count = cur_workers.get(cur_worker);

                cur_worker_count--;

                if (cur_worker_count == 0) {
                    cur_workers.remove(cur_worker);
                } else {
                    cur_workers.put(cur_worker, cur_worker_count);
                }
            } else {
                Integer weakest_worker = cur_workers.ceilingKey(cur_task - strength);
                if (weakest_worker == null || used_pills >= pills) return false;

                used_pills++;

                int weakest_worker_count = cur_workers.get(weakest_worker);
                weakest_worker_count--;
                if (weakest_worker_count == 0) {
                    cur_workers.remove(weakest_worker);
                } else {
                    cur_workers.put(weakest_worker, weakest_worker_count);
                }
            }
        }
        return true;
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int low = 0, high = Math.min(tasks.length, workers.length);
        int assigned = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAssign(mid, workers, tasks, pills, strength)) {
                assigned = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return assigned;
    }
}