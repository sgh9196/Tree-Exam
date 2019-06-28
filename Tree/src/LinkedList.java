public class LinkedList {

    Node CreateNode() {

        Node n = new Node();

        n.setNumber(0);
        n.setLeft(null);
        n.setRight(null);

        return n;

    }

    void InsertNode(Node root, int Number) {

        Node n;

        n = CreateNode();
        n.setNumber(Number);

        if (root.getNumber() == 0) {
            root.setNumber(Number);
        } else if (root.getNumber() > Number) {
            if (root.getLeft() == null) {
                root.setLeft(n);
            } else {
                InsertNode(root.getLeft(), Number);
            }
        } else if (root.getNumber() < Number) {
            if (root.getRight() == null) {
                root.setRight(n);
            } else {
                InsertNode(root.getRight(), Number);
            }
        }

    }

    int CountNode(Node root) {

        if (root != null && root.getNumber() != 0) {
            return (CountNode(root.getLeft()) + 1) + (CountNode(root.getRight()) + 1);
        }

        return -1;

    }

    boolean SearchNode(Node root, int Number) {
        // 값이 있는지 판단 TRUE AND FALSE
        if (root != null) {
            if (root.getNumber() > Number) {
                return SearchNode(root.getLeft(), Number);
            } else if (root.getNumber() < Number) {
                return SearchNode(root.getRight(), Number);
            } else if (root.getNumber() == Number) {
                return true;
            }
        }

        return false;

    }

    void SearchNode2(Node root, int Number) {
        // Search에서 TRUE이면 찾은 값까지 오는 길의 데이터 출력
        if (root != null) {
            if (root.getNumber() > Number) {
                System.out.print(root.getNumber() + " -> ");
                SearchNode2(root.getLeft(), Number);
            } else if (root.getNumber() < Number) {
                System.out.print(root.getNumber() + " -> ");
                SearchNode2(root.getRight(), Number);
            } else if (root.getNumber() == Number) {
                System.out.print(root.getNumber() + "  ");
                return;
            }
        }
    }

    int SearchNode3(Node root) {
        // 최대 깊이

        if (root != null) {
            if (root.getNumber() != 0) {
                if (root.getLeft() != null || root.getRight() != null) {

                    if (SearchNode3(root.getLeft()) > SearchNode3(root.getRight())) {
                        return SearchNode3(root.getLeft()) + 1;
                    } else {
                        return SearchNode3(root.getRight()) + 1;
                    }
                }
            } else {
                return -2;
            }
        }
        return -1;

    }

    int SearchNode4(Node root) {
        // 최대 폭
        if (root.getNumber() != 0) {
            return (int) Math.pow(2, (SearchNode3(root) + 2));
        }
        return 0;
    }

    Node[] NodeArySetting(Node[] ary) {

        for (int i = 0; i < ary.length; i++) {

            Node n = new Node();

            n.setNumber(0);
            n.setLeft(null);
            n.setRight(null);

            ary[i] = n;

        }
        return ary;
    }

    void LevelOderNode(Node root) {

        int high = 0;
        int length = 0;
        int temp = 0;
        int All_count = 0, add = 0;
        Node[] ary;

        All_count = CountNode(root) + 1;

        high = SearchNode3(root) + 2;
        for (int i = 0; i < high; i++) {
            length += (int) Math.pow(2, i);
        }
        // System.out.println("1. length: "+length);

        ary = new Node[length + 1];

        ary = NodeArySetting(ary);
        // System.out.println("2. length: " + ary.length);

        // System.out.println(Arrays.toString(ary));

        ary[1] = root;

        for (;;) {

            temp++;

            if (ary[temp].getLeft() != null) {
                ary[temp * 2] = ary[temp].getLeft();
            }

            if (ary[temp].getRight() != null) {
                ary[(temp * 2) + 1] = ary[temp].getRight();
            }

            // System.out.println("All >> " + All_count + " Temp >> " + temp);
            if (All_count == temp)
                break;

        }

        LevelPrint(ary, high);

    }

    void LevelPrint(Node[] ary, int high) {

        int f = 0;

        for (int i = 0; i < high; i++) {
            f = (int) (Math.pow(2, i));

            System.out.print("Level " + (i + 1) + " : ");
            for (int k = f; k < f + f; k++) {
                if (ary[k].getNumber() != 0) {
                    System.out.print(ary[k].getNumber() + "  ");
                }
            }
            System.out.println();
        }

    }

    int NoChildNode(Node root) {

        // 자식이 없는 노드 검색

        if (root == null)
            return 0;

        if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        }

        return NoChildNode(root.getLeft()) + NoChildNode(root.getRight());

    }

    int DeleteNode(Node root, int Key) {

        Node p, c;

        p = c = root;

        boolean Temp = false;
        
        while (c.getNumber() != Key) {
            p = c;
            if (c.getNumber() > Key) {
                Temp = true;
                c = c.getLeft();
            } else if (c.getNumber() < Key) {
                Temp = false;
                c = c.getRight();
            }
            if (c == null) {
                return 0;
            }
        }

        // 자식 없음
        if (c.getLeft() == null && c.getRight() == null) {
            if (c == root) {
                root.setNumber(0);
                return 0;
            }
            if (Temp == true) {
                p.setLeft(null);
            } else {
                p.setRight(null);
            }
        }
        // 자식 하나
        else if (c.getRight() == null) {
            if (c == root) {
                root = c.getLeft();
            } else if (Temp) {
                p.setLeft(c.getLeft());
            } else {
                p.setRight(c.getLeft());
            }
        } else if (c.getLeft() == null) {
            if (c == root) {
                root = c.getRight();
            } else if (Temp) {
                p.setLeft(c.getRight());
            } else {
                p.setRight(c.getRight());
            }
        }
        // 자식 두개
        return 1;
    }


    void InorderPrint(Node root) {

        // 5 10 15

        if (root != null) {
            PrePrint(root.getLeft());
            System.out.print(root.getNumber() + "   ");
            PrePrint(root.getRight());
        }
    }

    void PrePrint(Node root) {

        // 10 5 15

        if (root != null) {
            System.out.print(root.getNumber() + "   ");
            PrePrint(root.getLeft());
            PrePrint(root.getRight());
        }

    }

    void PostPrint(Node root) {

        // 5 15 10

        if (root != null) {
            PrePrint(root.getLeft());
            PrePrint(root.getRight());
            System.out.print(root.getNumber() + "   ");
        }

    }

}