package data.tree;

import java.util.List;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.tree
 * @Author: xuyifang
 * @CreateTime: 2021-08-23 16:34
 * @Description:
 */
public interface NestedInteger {

    public boolean isInteger();					// true是整数，false是nestedList

    public Integer getInteger();				// 获得整数，如果是nestedList，返回null

    public List<NestedInteger> getList();		// 获得nestedList，如果是整数，返回空的List
}
