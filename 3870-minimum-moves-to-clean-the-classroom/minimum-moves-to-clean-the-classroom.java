class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        char[][] grid = new char[m][n];
        int startR = -1, startC = -1;
        List<int[]> litters = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = classroom[i].charAt(j);
                if (grid[i][j] == 'S') { startR = i; startC = j; }
                if (grid[i][j] == 'L') litters.add(new int[]{i, j});
            }
        }
        
        int litterCount = litters.size();
        int allMask = (1 << litterCount) - 1;
        Map<String, Integer> litterIndex = new HashMap<>();
        for (int i = 0; i < litterCount; i++) {
            litterIndex.put(litters.get(i)[0] + "," + litters.get(i)[1], i);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startR, startC, energy, 0, 0});
        
        Map<String, Integer> visitedEnergy = new HashMap<>();
        visitedEnergy.put(startR + "," + startC + "," + 0, energy);
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], e = cur[2], mask = cur[3], moves = cur[4];
            
            if (mask == allMask) return moves;
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (grid[nr][nc] == 'X') continue;
                
                int ne = e - 1;
                if (ne < 0) continue;
                if (grid[nr][nc] == 'R') ne = energy;
                
                int newMask = mask;
                if (grid[nr][nc] == 'L') {
                    int idx = litterIndex.get(nr + "," + nc);
                    newMask |= (1 << idx);
                }
                
                String key = nr + "," + nc + "," + newMask;
                if (!visitedEnergy.containsKey(key) || visitedEnergy.get(key) < ne) {
                    visitedEnergy.put(key, ne);
                    q.offer(new int[]{nr, nc, ne, newMask, moves + 1});
                }
            }
        }
        
        return -1;
    }
}
