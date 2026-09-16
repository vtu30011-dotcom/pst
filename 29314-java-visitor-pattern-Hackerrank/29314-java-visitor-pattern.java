queue.add(0);
        parent[0] = -2;
        depth[0] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph[u]) {
                if (parent[v] == -1) {
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    queue.add(v);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            Color color = colors[i] == 0 ? Color.RED : Color.GREEN;

            if (graph[i].size() == 1 && i != 0) {
                nodes[i] = new TreeLeaf(values[i], color, depth[i]);
            } else {
                nodes[i] = new TreeNode(values[i], color, depth[i]);
            }
        }

        for (int i = 1; i < n; i++) {
            TreeNode p = (TreeNode) nodes[parent[i]];
            p.addChild(nodes[i]);
        }

        return nodes[0];
    }



    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna