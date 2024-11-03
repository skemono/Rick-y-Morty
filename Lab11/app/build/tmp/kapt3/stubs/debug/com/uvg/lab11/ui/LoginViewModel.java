package com.uvg.lab11.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \'2\u00020\u0001:\u0002\'(B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fJ\u0011\u0010\"\u001a\u00020\u001fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\u0011\u0010$\u001a\u00020\u001fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\rR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006)"}, d2 = {"Lcom/uvg/lab11/ui/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "characterDao", "Lcom/uvg/lab11/room/data/localdb/dao/CharacterDao;", "locationDao", "Lcom/uvg/lab11/room/data/localdb/dao/LocationDao;", "dataStoreUserPrefs", "Lcom/uvg/lab11/data/DataStorePrefs;", "(Lcom/uvg/lab11/room/data/localdb/dao/CharacterDao;Lcom/uvg/lab11/room/data/localdb/dao/LocationDao;Lcom/uvg/lab11/data/DataStorePrefs;)V", "_loginState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/uvg/lab11/ui/LoginViewModel$LoginState;", "_username", "", "characters", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/uvg/lab11/util/Character;", "getCharacters", "()Lkotlinx/coroutines/flow/StateFlow;", "setCharacters", "(Lkotlinx/coroutines/flow/StateFlow;)V", "locations", "Lcom/uvg/lab11/util/Location;", "getLocations", "setLocations", "loginState", "getLoginState", "username", "getUsername", "checkLoginStatus", "", "login", "logout", "refreshCharacters", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshLocations", "updateUsername", "name", "Companion", "LoginState", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.uvg.lab11.room.data.localdb.dao.CharacterDao characterDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.uvg.lab11.room.data.localdb.dao.LocationDao locationDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.uvg.lab11.data.DataStorePrefs dataStoreUserPrefs = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uvg.lab11.ui.LoginViewModel.LoginState> _loginState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uvg.lab11.ui.LoginViewModel.LoginState> loginState = null;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.uvg.lab11.util.Character>> characters;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.uvg.lab11.util.Location>> locations;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _username = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> username = null;
    @org.jetbrains.annotations.NotNull
    private static final androidx.lifecycle.ViewModelProvider.Factory Factory = null;
    @org.jetbrains.annotations.NotNull
    public static final com.uvg.lab11.ui.LoginViewModel.Companion Companion = null;
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    com.uvg.lab11.room.data.localdb.dao.CharacterDao characterDao, @org.jetbrains.annotations.NotNull
    com.uvg.lab11.room.data.localdb.dao.LocationDao locationDao, @org.jetbrains.annotations.NotNull
    com.uvg.lab11.data.DataStorePrefs dataStoreUserPrefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uvg.lab11.ui.LoginViewModel.LoginState> getLoginState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.uvg.lab11.util.Character>> getCharacters() {
        return null;
    }
    
    public final void setCharacters(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.uvg.lab11.util.Character>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.uvg.lab11.util.Location>> getLocations() {
        return null;
    }
    
    public final void setLocations(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<? extends java.util.List<com.uvg.lab11.util.Location>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getUsername() {
        return null;
    }
    
    private final void checkLoginStatus() {
    }
    
    public final void updateUsername(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    public final void login() {
    }
    
    public final void logout() {
    }
    
    private final java.lang.Object refreshCharacters(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object refreshLocations(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/uvg/lab11/ui/LoginViewModel$Companion;", "", "()V", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.lifecycle.ViewModelProvider.Factory getFactory() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/uvg/lab11/ui/LoginViewModel$LoginState;", "", "()V", "Error", "Initial", "Loading", "LoggedOut", "Success", "Lcom/uvg/lab11/ui/LoginViewModel$LoginState$Error;", "Lcom/uvg/lab11/ui/LoginViewModel$LoginState$Initial;", "Lcom/uvg/lab11/ui/LoginViewModel$LoginState$Loading;", "Lcom/uvg/lab11/ui/LoginViewModel$LoginState$LoggedOut;", "Lcom/uvg/lab11/ui/LoginViewModel$LoginState$Success;", "app_debug"})
    public static abstract class LoginState {
        
        private LoginState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/uvg/lab11/ui/LoginViewModel$LoginState$Error;", "Lcom/uvg/lab11/ui/LoginViewModel$LoginState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.uvg.lab11.ui.LoginViewModel.LoginState {
            @org.jetbrains.annotations.NotNull
            private final java.lang.String message = null;
            
            public Error(@org.jetbrains.annotations.NotNull
            java.lang.String message) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getMessage() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.uvg.lab11.ui.LoginViewModel.LoginState.Error copy(@org.jetbrains.annotations.NotNull
            java.lang.String message) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override
            @org.jetbrains.annotations.NotNull
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/uvg/lab11/ui/LoginViewModel$LoginState$Initial;", "Lcom/uvg/lab11/ui/LoginViewModel$LoginState;", "()V", "app_debug"})
        public static final class Initial extends com.uvg.lab11.ui.LoginViewModel.LoginState {
            @org.jetbrains.annotations.NotNull
            public static final com.uvg.lab11.ui.LoginViewModel.LoginState.Initial INSTANCE = null;
            
            private Initial() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/uvg/lab11/ui/LoginViewModel$LoginState$Loading;", "Lcom/uvg/lab11/ui/LoginViewModel$LoginState;", "()V", "app_debug"})
        public static final class Loading extends com.uvg.lab11.ui.LoginViewModel.LoginState {
            @org.jetbrains.annotations.NotNull
            public static final com.uvg.lab11.ui.LoginViewModel.LoginState.Loading INSTANCE = null;
            
            private Loading() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/uvg/lab11/ui/LoginViewModel$LoginState$LoggedOut;", "Lcom/uvg/lab11/ui/LoginViewModel$LoginState;", "()V", "app_debug"})
        public static final class LoggedOut extends com.uvg.lab11.ui.LoginViewModel.LoginState {
            @org.jetbrains.annotations.NotNull
            public static final com.uvg.lab11.ui.LoginViewModel.LoginState.LoggedOut INSTANCE = null;
            
            private LoggedOut() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/uvg/lab11/ui/LoginViewModel$LoginState$Success;", "Lcom/uvg/lab11/ui/LoginViewModel$LoginState;", "username", "", "(Ljava/lang/String;)V", "getUsername", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Success extends com.uvg.lab11.ui.LoginViewModel.LoginState {
            @org.jetbrains.annotations.NotNull
            private final java.lang.String username = null;
            
            public Success(@org.jetbrains.annotations.NotNull
            java.lang.String username) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getUsername() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.uvg.lab11.ui.LoginViewModel.LoginState.Success copy(@org.jetbrains.annotations.NotNull
            java.lang.String username) {
                return null;
            }
            
            @java.lang.Override
            public boolean equals(@org.jetbrains.annotations.Nullable
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override
            @org.jetbrains.annotations.NotNull
            public java.lang.String toString() {
                return null;
            }
        }
    }
}