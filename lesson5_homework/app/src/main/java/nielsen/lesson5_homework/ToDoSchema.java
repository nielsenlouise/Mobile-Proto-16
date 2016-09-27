package nielsen.lesson5_homework;

import android.provider.BaseColumns;

/**
 * Created by lnielsen on 9/26/16.
 */

public final class ToDoSchema {
    private ToDoSchema() {}

    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "toDos";
        public static final String COLUMN_NAME_TEXT = "text";
        public static final String COLUMN_NAME_COMPLETE = "isComplete";
    }
}
