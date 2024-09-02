package io.flutter.embedding.engine.mutatorsstack;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class FlutterMutatorsStack {
    private List<Path> finalClippingPaths = new ArrayList();
    private Matrix finalMatrix = new Matrix();
    private List<FlutterMutator> mutators = new ArrayList();

    public class FlutterMutator {
        private Matrix matrix;
        private Path path;
        private float[] radiis;
        private Rect rect;
        private FlutterMutatorType type;

        public FlutterMutator(Matrix matrix2) {
            this.type = FlutterMutatorType.TRANSFORM;
            this.matrix = matrix2;
        }

        public FlutterMutator(Path path2) {
            this.type = FlutterMutatorType.CLIP_PATH;
            this.path = path2;
        }

        public FlutterMutator(Rect rect2) {
            this.type = FlutterMutatorType.CLIP_RECT;
            this.rect = rect2;
        }

        public FlutterMutator(Rect rect2, float[] fArr) {
            this.type = FlutterMutatorType.CLIP_RRECT;
            this.rect = rect2;
            this.radiis = fArr;
        }

        public Matrix getMatrix() {
            return this.matrix;
        }

        public Path getPath() {
            return this.path;
        }

        public Rect getRect() {
            return this.rect;
        }

        public FlutterMutatorType getType() {
            return this.type;
        }
    }

    public enum FlutterMutatorType {
        CLIP_RECT,
        CLIP_RRECT,
        CLIP_PATH,
        TRANSFORM,
        OPACITY
    }

    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }

    public List<FlutterMutator> getMutators() {
        return this.mutators;
    }

    public void pushClipRRect(int i5, int i6, int i7, int i8, float[] fArr) {
        Rect rect = new Rect(i5, i6, i7, i8);
        this.mutators.add(new FlutterMutator(rect, fArr));
        Path path = new Path();
        path.addRoundRect(new RectF(rect), fArr, Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRect(int i5, int i6, int i7, int i8) {
        Rect rect = new Rect(i5, i6, i7, i8);
        this.mutators.add(new FlutterMutator(rect));
        Path path = new Path();
        path.addRect(new RectF(rect), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushTransform(float[] fArr) {
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        FlutterMutator flutterMutator = new FlutterMutator(matrix);
        this.mutators.add(flutterMutator);
        this.finalMatrix.preConcat(flutterMutator.getMatrix());
    }
}
