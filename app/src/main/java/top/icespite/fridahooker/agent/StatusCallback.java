package top.icespite.fridahooker.agent;

public interface StatusCallback {
    void onSuccess();
    void onFailure(Throwable e);
}
