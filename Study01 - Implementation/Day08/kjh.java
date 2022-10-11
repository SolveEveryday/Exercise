import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        
        Blocks blocks = new Blocks(inputs[0], inputs[1]);
        blocks.foldAndPaint(inputs[2], inputs[3], inputs[4], inputs[5], inputs[6], inputs[7]);
        
        int unpaintedCount = blocks.countUnpainted();
        System.out.print(unpaintedCount);
    }
}

class Blocks {
    private Block[][] blocks;
    private int width;
    private int height;
    private int foldedY = 0;
    private int foldedX = 0;

    public Blocks(int width, int height) {
        this.width = width;
        this.height = height;

        this.blocks = new Block[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {;
                blocks[y][x] = new Block(y, x);
            }
        }
    }

    public void foldAndPaint(int f, int c, int x1, int y1, int x2, int y2) {
        foldLeftToRight(f);
        foldUpToDown(c);
        paint(x1, y1, x2, y2);
    }

    private void foldLeftToRight(int f) {
        if (f > width - f) {
            reverseLeftRight();
            f = width - f;
        }

        int widthToFold = Math.min(f, width-f);
        for (int y = 0; y < height; y++) {
            for (int i = 1; i <= widthToFold; i++) {
                int x1 = f - i;
                int x2 = f + i - 1;
                blocks[y][x1].merge(blocks[y][x2]);
            }
        }

        foldedX = (f < width - f) ? widthToFold : 0;
    }

    private void reverseLeftRight() {
        for (int y = 0; y < height; y++) {
            for (int i = 0; i < width / 2; i++) {
                Block tmp = blocks[y][i];
                blocks[y][i] = blocks[y][width-i-1];
                blocks[y][width-i-1] = tmp;
            }
        }
    }

    private void foldUpToDown(int c) {
        int heightToFold = height / (c + 1);

        for (int tangent = height - heightToFold; tangent >= heightToFold; tangent -= heightToFold) {
            for (int x = 0; x < width; x++) {
                for (int i = 1; i <= heightToFold; i++) {
                    int y1 = tangent - i;
                    int y2 = tangent + i - 1;
                    blocks[y1][x].merge(blocks[y2][x]);
                }
            }
        }

        foldedY = height - heightToFold;
    }

    private void paint(int x1, int y1, int x2, int y2) {
        for (int y = y1 + foldedY; y < y2 + foldedY; y++) {
            for (int x = x1 + foldedX; x < x2 + foldedX; x++) {
                blocks[y][x].paint();
            }
        }
    }

    public int countUnpainted() {
        int count = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (!blocks[y][x].isPainted()) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Block {
    public int y;
    public int x;
    private boolean painted;
    public MergedInfos mergedInfos;

    public Block(int y, int x) {
        this.y = y;
        this.x = x;
        this.painted = false;
        this.mergedInfos = null;
    }
    
    public boolean isMerged() {
        return this.mergedInfos != null;
    }

    public void merge(Block block) {
        if (isMerged() && block.isMerged()) {
            MergedInfos mergedInfos = new MergedInfos();
            mergedInfos.blocks.addAll(this.mergedInfos.blocks);
            mergedInfos.blocks.addAll(block.mergedInfos.blocks);
            updateMergedInfos(this.mergedInfos.blocks, mergedInfos);
            updateMergedInfos(block.mergedInfos.blocks, mergedInfos);
            return;
        }

        if (isMerged() && !block.isMerged()) {
            mergedInfos.merge(block);
            block.mergedInfos = this.mergedInfos;
            return;
        }

        if (!isMerged() && block.isMerged()) {
            block.mergedInfos.merge(this);
            this.mergedInfos = block.mergedInfos;
            return;
        }

        MergedInfos mergedInfos = new MergedInfos();
        mergedInfos.merge(this);
        mergedInfos.merge(block);
        this.mergedInfos = mergedInfos;
        block.mergedInfos = mergedInfos;
    }

    private void updateMergedInfos(Set<Block> blocks, MergedInfos mergedInfos) {
        for (Block block : blocks) {
            block.mergedInfos = mergedInfos;
        }
    }

    public void paint() {
        if (isMerged()) {
            mergedInfos.paint();
            return;
        }
        this.painted = true;
    }

    public boolean isPainted() {
        if (isMerged()) {
            return this.mergedInfos.painted;
        }
        return this.painted;
    }
}

class MergedInfos {
    public Set<Block> blocks;
    public boolean painted;

    public MergedInfos() {
        this.blocks = new HashSet<>();
        this.painted = false;
    }

    public void paint() {
        this.painted = true;
    }

    public void merge(Block block) {
        blocks.add(block);
    }
}