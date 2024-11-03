package com.uvg.lab11.room.data.localdb.di;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/uvg/lab11/room/data/localdb/di/Dependencies;", "", "()V", "database", "Lcom/uvg/lab11/room/data/localdb/AppDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "provideDatabase", "app_release"})
public final class Dependencies {
    @org.jetbrains.annotations.Nullable
    private static com.uvg.lab11.room.data.localdb.AppDatabase database;
    @org.jetbrains.annotations.NotNull
    public static final com.uvg.lab11.room.data.localdb.di.Dependencies INSTANCE = null;
    
    private Dependencies() {
        super();
    }
    
    private final com.uvg.lab11.room.data.localdb.AppDatabase buildDatabase(android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uvg.lab11.room.data.localdb.AppDatabase provideDatabase(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
}