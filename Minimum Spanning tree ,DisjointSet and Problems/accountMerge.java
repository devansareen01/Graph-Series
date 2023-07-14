 int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (!map.containsKey(accounts.get(i).get(j))) {
                    map.put(accounts.get(i).get(j), i);
                } else {
                    ds.unionBySize(i, map.get(accounts.get(i).get(j)));
                }
            }
        }

        ArrayList<ArrayList<String>> mergedMail = new ArrayList<>();

        for (int i = 0; i < n; i++)
            mergedMail.add(new ArrayList<String>());

        for (Map.Entry<String, Integer> it : map.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUltimateParent(it.getValue());
            mergedMail.get(node).add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).size() == 0)
                continue;
            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : mergedMail.get(i)) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
