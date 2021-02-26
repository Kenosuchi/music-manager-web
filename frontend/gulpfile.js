const gulp = require('gulp');
var webserver = require('gulp-webserver');

gulp.task('webserver', function() {
    gulp.src('script')
        .pipe(webserver({
            fallback: 'index.html',
            livereload: true,
            open: true,
            proxies: [
                { source: '/accounts', target: 'http://localhost:8080/rest/accounts/' },
                { source: '/artists', target: 'http://localhost:8080/rest/artists/' },
                { source: '/songs', target: 'http://localhost:8080/rest/songs/' },
                { source: '/albums', target: 'http://localhost:8080/rest/albums/' },
                { source: '/listeners', target: 'http://localhost:8080/rest/listeners/' },
                { source: '/playlists', target: 'http://localhost:8080/rest/playlists/' },
            ]
        }));
});