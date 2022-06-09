/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

//package com.liferay.portlet.asset.util.comparator;
package com.liferay.asset.publisher.web.internal.util;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Eudaldo Alonso
 */
public class AssetCategoryTitleComparator
	extends OrderByComparator<AssetCategory> {

	public static final String ORDER_BY_ASC = "AssetCategory.title ASC";

	public static final String ORDER_BY_DESC = "AssetCategory.title DESC";

	public static final String[] ORDER_BY_FIELDS = {"title"};

	public AssetCategoryTitleComparator() {
		this(true);
	}

	public AssetCategoryTitleComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(
		AssetCategory assetCategory1, AssetCategory assetCategory2) {
		int value = 0;
		if (assetCategory1.getTitle() == null && assetCategory2.getTitle() == null){value = 0;}
        if (assetCategory1.getTitle() == null) { value = -1;}
        if (assetCategory2.getTitle() == null) { value =  1;}
        value = assetCategory2.getTitle().compareTo(assetCategory2.getTitle());

		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}

		return ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}
