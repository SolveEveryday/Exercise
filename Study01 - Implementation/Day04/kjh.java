import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        final int PICTURES_LIMIT = Integer.parseInt(br.readLine());
        br.readLine();
        final String[] RECOMMENDS_ARR = br.readLine().trim().split(" ");

        Pictures pictures = new Pictures(PICTURES_LIMIT);
        for (String recommend : RECOMMENDS_ARR) {
            int recommendNum = Integer.parseInt(recommend);
            pictures.recommendPicture(recommendNum);
        }

        System.out.print(pictures.getPictureNumbers());
    }
}

class Pictures {
    private int limit;
    private List<Picture> pictures;

    public Pictures(int limit) {
        this.limit = limit;
        pictures = new ArrayList<>();
    }

    public void recommendPicture(int number) {
        Picture picture = new Picture(number);

        int existingIdx = pictures.indexOf(picture);
        if (existingIdx >= 0) {
            pictures.get(existingIdx).recommend();
            return;
        }

        if (pictures.size() >= limit) {
            removeOneUnpoular();
        }
        pictures.add(picture);
    }

    private void removeOneUnpoular() {
        int mostUnpopularIdx = -1;
        int mostUnpopularRecommends = 1000;
        for (int i = 0; i < pictures.size(); i++) {
            Picture picture = pictures.get(i);
            if (picture.recommend < mostUnpopularRecommends) {
                mostUnpopularIdx = i;
                mostUnpopularRecommends = picture.recommend;
            }
        }
        pictures.remove(mostUnpopularIdx);
    }

    public String getPictureNumbers() {
        return pictures.stream()
            .sorted((p1, p2) -> p1.number - p2.number)
            .map(p -> String.valueOf(p.number))
            .collect(Collectors.joining(" "));
    }
}

class Picture {
    public int number;
    public int recommend;

    public Picture(int number) {
        this.number = number;
        this.recommend = 1;
    }

    public void recommend() {
        this.recommend++;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + number;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Picture other = (Picture) obj;
        if (number != other.number)
            return false;
        return true;
    }
}