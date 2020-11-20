<template>
    <div class="m-8 max-w-sm rounded overflow-hidden shadow-lg" style="max-width: 20rem">
        <img class="w-full" src="/pics/Sticks'n'pucks.png" alt="logo">
        <div class="h-48 lg:h-auto lg:w-48 flex-none bg-cover rounded-t lg:rounded-t-none lg:rounded-l text-center overflow-hidden"
             style="background-image: url('/pics/Sticks\'n\'pucks.png')">
        </div>
        <div class="border-r border-b border-l border-gray-400 lg:border-l-0 lg:border-t lg:border-gray-400 bg-white rounded-b lg:rounded-b-none lg:rounded-r p-4 flex flex-col justify-between leading-normal">
            <div class="mb-8 text-center content-center">
                <div class="text-gray-1200 font-bold text-xl mb-2">{{ playername }}</div>
                <p class="text-gray-700 text-base">
                    <b> Height: </b> {{ height }} <br>
                    <b> Weight: </b> {{ weight}} <br>
                    <b> Position: </b> {{ position }}<br>
                    <b> Shoots: </b> {{shoots}}
                </p>
            </div>
            <div class="flex items-center text-center content-center flex-wrap">
                <div class="text-sm flex-1">
                    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded-full">
                        View the full player statistics
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "PlayerCard",
        props: {
            playername: {
                type: String,
                required: true,
            },
            height: {
                type: String,
                required: true,
            },
            weight: {
                type: String,
                required: true,
            },
            position: {
                type: String,
                required: true,
            },
            shoots: {
                type: String,
                required: true,
            },
            id: {
                type: String,
                required: true
            }
        }
    };
</script>

<style>
    @import "https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css";
</style>