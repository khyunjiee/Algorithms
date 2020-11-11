package nov.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1966 {
    static class Element {
        int position, value;

        public Element(int position, int value) {
            this.position = position;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            ArrayList<Element> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list.add(new Element(j, Integer.parseInt(st.nextToken())));
            }

            int count = 1;
            base:
            while (!list.isEmpty()) {
                Element element = list.get(0);
                for (int j = 1; j < list.size(); j++) {
                    if (element.value < list.get(j).value) {
                        list.remove(0);
                        list.add(element);
                        continue base;
                    }
                }
                if (element.position == m) break;
                list.remove(0);
                count++;
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}
