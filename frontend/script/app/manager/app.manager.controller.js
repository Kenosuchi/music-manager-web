angular
    .module("MusicManagerApp")
    .controller("ManagerAppController", ManagerAppController);

function ManagerAppController(AppService, $cookies, $route) {
    var vm = this;
    vm.accountLogin = {
        accountUsername: "",
        accountPassword: ""
    }
    vm.userAlreadyLogin = false;
    vm.menuItemList = {
        Song: 0,
        Listener: 0,
        Album: 0,
        Artist: 0
    }

    vm.loginUser = loginUser;
    vm.logout = logout;
    vm.menuClick = menuClick;
    checkUserAlreadyLogin();

    function loginUser() {
        if (!vm.userAlreadyLogin)
            AppService.login(vm.accountLogin).then(
                function(res) {
                    console.log(res.data.message);
                    vm.userAlreadyLogin = true;
                    $route.reload();
                    // var headerName = 'bearer';
                    // sessionStorage.setItem(headerName, res.headers(headerName));
                    // localStorage.setItem(headerName, res.headers(headerName));
                },
                function(res) {
                    console.log("error");
                }
            )
    }

    function logout() {
        if (vm.userAlreadyLogin) {
            $cookies.remove('access-token');
            vm.userAlreadyLogin = false;
        }
    }

    function menuClick(itemName) {
        switch (itemName) {
            case "Song":
                vm.menuItemList = {
                    Song: 1,
                    Listener: 0,
                    Album: 0,
                    Artist: 0
                }
                break;
            case "Listener":
                vm.menuItemList = {
                    Song: 0,
                    Listener: 1,
                    Album: 0,
                    Artist: 0
                }
                break;
            case "Album":
                vm.menuItemList = {
                    Song: 0,
                    Listener: 0,
                    Album: 1,
                    Artist: 0
                }
                break;
            case "Artist":
                vm.menuItemList = {
                    Song: 0,
                    Listener: 0,
                    Album: 0,
                    Artist: 1
                }
                break;
            default:
                vm.menuItemList = {
                    Song: 0,
                    Listener: 0,
                    Album: 0,
                    Artist: 0
                }
                break;
        }
    }

    function checkUserAlreadyLogin() {
        var value = $cookies.get('access-token');
        if (value === undefined)
            vm.userAlreadyLogin = false;
        else {
            console.log("User already login!");
            vm.userAlreadyLogin = true;
        }
    }

    $('#submitAccountModalForm').click(function() {
        $('#ModalAccount').modal('hide');
    });

}