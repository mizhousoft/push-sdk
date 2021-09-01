package com.mizhousoft.push.util;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.mizhousoft.push.exception.PushException;

/**
 * Asserts
 *
 * @version
 */
public abstract class PushAsserts
{
	public static void notEmpty(Map<?, ?> map, String message) throws PushException
	{
		if (CollectionUtils.isEmpty(map))
		{
			throw new PushException(message);
		}
	}

	public static void notEmpty(Collection<?> collection, String message) throws PushException
	{
		if (CollectionUtils.isEmpty(collection))
		{
			throw new PushException(message);
		}
	}

	public static void notEmpty(String[] values, String message) throws PushException
	{
		if (ArrayUtils.isEmpty(values))
		{
			throw new PushException(message);
		}
	}

	public static void notEmpty(String value, String message) throws PushException
	{
		if (StringUtils.isBlank(value))
		{
			throw new PushException(message);
		}
	}

	public static void notNull(Object object, String message) throws PushException
	{
		if (object == null)
		{
			throw new PushException(message);
		}
	}
}
