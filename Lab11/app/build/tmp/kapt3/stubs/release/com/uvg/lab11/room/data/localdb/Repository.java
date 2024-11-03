package com.uvg.lab11.room.data.localdb;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0011\u0010\u0019\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/uvg/lab11/room/data/localdb/Repository;", "", "characterDao", "Lcom/uvg/lab11/room/data/localdb/dao/CharacterDao;", "locationDao", "Lcom/uvg/lab11/room/data/localdb/dao/LocationDao;", "charactersDb", "Lcom/uvg/lab11/util/CharacterDb;", "locationsDb", "LLocationDb;", "(Lcom/uvg/lab11/room/data/localdb/dao/CharacterDao;Lcom/uvg/lab11/room/data/localdb/dao/LocationDao;Lcom/uvg/lab11/util/CharacterDb;LLocationDb;)V", "characters", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/uvg/lab11/util/Character;", "getCharacters", "()Lkotlinx/coroutines/flow/Flow;", "locations", "Lcom/uvg/lab11/util/Location;", "getLocations", "getCharacterById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocationById", "refreshCharacters", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshLocations", "app_release"})
public final class Repository {
    @org.jetbrains.annotations.NotNull
    private final com.uvg.lab11.room.data.localdb.dao.CharacterDao characterDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.uvg.lab11.room.data.localdb.dao.LocationDao locationDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.uvg.lab11.util.CharacterDb charactersDb = null;
    @org.jetbrains.annotations.NotNull
    private final LocationDb locationsDb = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.uvg.lab11.util.Character>> characters = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.uvg.lab11.util.Location>> locations = null;
    
    public Repository(@org.jetbrains.annotations.NotNull
    com.uvg.lab11.room.data.localdb.dao.CharacterDao characterDao, @org.jetbrains.annotations.NotNull
    com.uvg.lab11.room.data.localdb.dao.LocationDao locationDao, @org.jetbrains.annotations.NotNull
    com.uvg.lab11.util.CharacterDb charactersDb, @org.jetbrains.annotations.NotNull
    LocationDb locationsDb) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.uvg.lab11.util.Character>> getCharacters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.uvg.lab11.util.Location>> getLocations() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object refreshCharacters(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object refreshLocations(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getCharacterById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uvg.lab11.util.Character> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLocationById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uvg.lab11.util.Location> $completion) {
        return null;
    }
}