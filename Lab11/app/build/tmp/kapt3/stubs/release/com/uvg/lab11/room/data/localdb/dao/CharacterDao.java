package com.uvg.lab11.room.data.localdb.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\'J\u001b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/uvg/lab11/room/data/localdb/dao/CharacterDao;", "", "deleteAllCharacters", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCharacters", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/uvg/lab11/room/data/localdb/entity/CharacterEntity;", "getCharacterById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCharacters", "characters", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
@androidx.room.Dao
public abstract interface CharacterDao {
    
    @androidx.room.Query(value = "SELECT * FROM characters")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.uvg.lab11.room.data.localdb.entity.CharacterEntity>> getAllCharacters();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertCharacters(@org.jetbrains.annotations.NotNull
    java.util.List<com.uvg.lab11.room.data.localdb.entity.CharacterEntity> characters, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM characters WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getCharacterById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uvg.lab11.room.data.localdb.entity.CharacterEntity> $completion);
    
    @androidx.room.Query(value = "DELETE FROM characters")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAllCharacters(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}