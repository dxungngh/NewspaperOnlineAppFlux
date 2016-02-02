package com.daniel.flux.newspaper.callback;

/**
 * Created by danielnguyen on 1/12/16.
 */

import com.daniel.flux.newspaper.database.model.News;

import java.util.List;

public interface OnFetchNewsesListListener extends GenericListener<List<News>> {
}
