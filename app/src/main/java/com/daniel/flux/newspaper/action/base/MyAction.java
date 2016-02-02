package com.daniel.flux.newspaper.action.base;

/**
 * Created by danielnguyen on 1/18/16.
 */
public class MyAction implements Action {
    private ActionType type;
    private DataBundle data;

    public MyAction(ActionType type, DataBundle data) {
        this.type = type;
        this.data = data;
    }

    @Override
    public ActionType getType() {
        return this.type;
    }

    @Override
    public DataBundle getData() {
        return this.data;
    }

    public enum MyActionType implements ActionType {
        GET_CATEGORIES_LIST_SUCCESSFULLY,
        GET_CATEGORIES_LIST_FAIL,

        GET_NEWS_LIST_OF_CATEGORY_SUCCESSFULLY,
        GET_NEWS_LIST_OF_CATEGORY_FAIL,

        GET_NEWS_DETAIL_SUCCESSFULLY,
        GET_NEWS_DETAIL_FAIL
    }

    public enum MyDataKey implements DataKey {
        NEWS_LIST,
        NEWS_CONTENT,
        ERROR
    }
}
