package com.example.jngoogle.keionbu.util;

/**
 * Created by jngoogle on 2017/9/14.
 */

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * {@link RecyclerView} 的加载更多的代理类
 * <p>实现上拉加载更多功能<p/>
 */
public class LoadMoreDelegate {

    private static final String TAG = "LoadMoreDelegate";
    private final ILoadMoreSubject iLoadMoreSubject;
    private RecyclerView recyclerView;

    public LoadMoreDelegate(ILoadMoreSubject iLoadMoreSubject) {
    this.iLoadMoreSubject = iLoadMoreSubject;
    }

    /**
     * attach to recyclerView to help it loadmore
     *
     * @param recyclerView
     */
    public void attach(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new EndlessScrollListener(linearLayoutManager, iLoadMoreSubject));
    }

    public class EndlessScrollListener extends RecyclerView.OnScrollListener {

        private final LinearLayoutManager layoutManager;
        private final ILoadMoreSubject iLoadMoreSubject;

        public EndlessScrollListener(LinearLayoutManager layoutManager, ILoadMoreSubject iLoadMoreSubject) {
            this.layoutManager = layoutManager;
            this.iLoadMoreSubject = iLoadMoreSubject;
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if (dy < 0 || iLoadMoreSubject.isLoading()) {
                // no items
                return;
            }

            if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                // if scrolling to the bottom of list
                final int totalItemCount = layoutManager.getItemCount();
                final int lastVisibleItemPosition = layoutManager.findLastCompletelyVisibleItemPosition();
                if (lastVisibleItemPosition >= totalItemCount - 1) {
                    iLoadMoreSubject.onLoadMore();
                }
            } else {
                Log.e(TAG, "onScrolled: only suppot LinearLayoutManger");
            }

        }
    }

    public interface ILoadMoreSubject {
        boolean isLoading();

        void onLoadMore();
    }
}
