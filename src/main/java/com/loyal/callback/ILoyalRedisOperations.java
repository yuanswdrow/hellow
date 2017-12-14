package com.loyal.callback;

public interface ILoyalRedisOperations {
	<T> T execute(ILoyalConnectionCallback<T> action);

	String set(final String key, final String value);

	String get(final String key);
}
