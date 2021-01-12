<template>
    <div>
        <div id="sidebar" class="h-screen w-16 menu bg-white text-white px-4 flex items-center fixed shadow">
            <ul class="list-reset ">
                <li class="my-2 md:my-0">
                    <a href="/dashboard"
                       class="block py-1 md:py-3 pl-1 align-middle text-gray-600 no-underline hover:text-indigo-400">
                        <i class="fas fa-home fa-fw mr-3"></i><span class="w-full inline-block pb-1 md:pb-0 text-sm">Home</span>
                    </a>
                </li>
                <li class="my-2 md:my-0 ">
                    <a href="/teams/roster"
                       class="block py-1 md:py-3 pl-1 align-mi ddle text-gray-600 no-underline hover:text-indigo-400">
                        <i class="fas fa-tasks fa-fw mr-3"></i><span
                            class="w-full inline-block pb-1 md:pb-0 text-sm">Roster</span>
                    </a>
                </li>
                <li class="my-2 md:my-0">
                    <a href="/games/all"
                       class="block py-1 md:py-3 pl-1 align-middle text-gray-600 no-underline hover:text-indigo-400">
                        <i class="fas fa-poll fa-fw mr-3"></i><span
                            class="w-full inline-block pb-1 md:pb-0 text-sm">Games</span>
                    </a>
                </li>

                <li class="my-2 md:my-0">
                    <a href="#"
                       class="block py-1 md:py-3 pl-1 align-middle text-gray-600 no-underline hover:text-indigo-400">
                        <i class="fas fa-chart-area fa-fw mr-3"></i><span
                            class="w-full inline-block pb-1 md:pb-0 text-sm">My analytics</span>
                    </a>
                </li>

                <li class="my-2 md:my-0">
                    <a href="#"
                       class="block py-1 md:py-3 pl-1 align-middle text-gray-600 no-underline hover:text-indigo-400">
                        <i class="fas fa-exclamation-triangle fa-fw mr-3"></i><span
                            class="w-full inline-block pb-1 md:pb-0 text-sm">Penalties</span>
                    </a>
                </li>

                <li class="my-2 md:my-0">
                    <a href="/chat"
                       class="block py-1 md:py-3 pl-1 align-middle text-gray-600 no-underline hover:text-indigo-400">
                        <i class="far fa-comments fa-fw mr-3"></i><span
                            class="w-full inline-block pb-1 md:pb-0 text-sm">Chat</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Navbar",
        props: {},
    };
</script>

<style scoped>
    @import "https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css";

    #sidebar {
        transition: ease-in-out all .3s;
        z-index: 9999;
    }

    #sidebar span {
        opacity: 0;
        position: absolute;
        transition: ease-in-out all .1s;
    }

    #sidebar:hover {
        width: 150px;
        box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.25);
    }

    #sidebar:hover span {
        opacity: 1;
    }
</style>
<link href="https://unpkg.com/tailwindcss/dist/tailwind.min.css" rel="stylesheet">
